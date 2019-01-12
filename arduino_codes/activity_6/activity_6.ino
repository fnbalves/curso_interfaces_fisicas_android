void setup() {
  pinMode(LED_BUILTIN, OUTPUT);
  digitalWrite(LED_BUILTIN, LOW);
  
  Serial.begin(9600);
}

void loop() {
  if (Serial.available()){
    char c = Serial.read();

    if (c == 'a'){
      digitalWrite(LED_BUILTIN, HIGH);
    }else if (c == 'b'){
      digitalWrite(LED_BUILTIN, LOW);
    }
  }
}
