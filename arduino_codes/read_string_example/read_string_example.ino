void setup() {
    Serial.begin(9600);
    Serial.setTimeout(1000);
}

void loop() {
  if(Serial.available()){
    String s = Serial.readString();
    
    Serial.print("Recebi: ");
    Serial.println(s);
  }
}
