const http = require('http');
const port = 3000;

const SerialPort = require('serialport');
const Delimiter = require('@serialport/parser-delimiter');

var serialPort = new SerialPort('/dev/cu.usbmodem1411', 
{
    baudRate: 9600,    
});

const parser = serialPort.pipe(new Delimiter({delimiter: '\n'}));

parser.on('data', function(buffer){
    console.log('Recebi ', buffer.toString('utf8'));
});

function sendBySerial(data){
    serialPort.write(data, function(err, result){
        if (err){
            console.log('Erro ao enviar', err);
        }
    })
}
const requestHandler = (request, response) => {
    if(request.url.includes('favicon')){

    }else{
        if(request.url.includes('ligar')){
            response.end('LIGA');
            sendBySerial('L');
        }else{
            response.end('DESLIGA');
            sendBySerial('D');
        }
    }
}

const server = http.createServer(requestHandler);

server.listen(port, (err) => {
    if(err){
        return console.log('Erro: ', err);
    }

    console.log(`Servidor em execucao na porta ${port}`);
});

