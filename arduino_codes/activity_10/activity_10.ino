int pin_button = 2;

void setup() {
  pinMode(pin_button, INPUT);
  Serial.begin(9600);
  
}

void loop() {
  int val_button = digitalRead(pin_button);
  
  if(val_button==0){
    Serial.println("APERTOU");
    delay(100);
  }
}
