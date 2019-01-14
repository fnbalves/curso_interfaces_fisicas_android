char buffer[256];
int position = 0;

void setup() {
  Serial.begin(9600);
}

void loop() {
  //Nao bloqueia a execucao
  if(Serial.available()){
    char c = Serial.read();

    if(c == 'I'){
      position = 0;
    }else if(c == 'F'){
      buffer[position] = '\0';

      if(strlen(buffer) < 7){
        Serial.println("Mensagem incorreta");
      }else{
        String s = String(buffer);

        String s_num1 = s.substring(0,3);
        String s_num2 = s.substring(4,7);

        int num1 = s_num1.toInt();
        int num2 = s_num2.toInt();

        Serial.print("Soma :");
        Serial.println(num1 + num2);
      }
    }else if(position < 256){
      buffer[position] = c;
      position++;
    }
  }
  
}
