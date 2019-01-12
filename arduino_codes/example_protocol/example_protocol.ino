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

      int i = atoi(buffer);
      Serial.print("Recebi: ");
      Serial.println(i + 1);
    }else if(position < 256){
      buffer[position] = c;
      position++;
    }
  }
  
}
