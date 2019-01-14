void setup() {
  Serial.begin(9600);
}

void loop() {
  if(Serial.available()){
    String s = Serial.readStringUntil('\n');

    Serial.print("Recebi: ");
    Serial.println(s);
  }
}
