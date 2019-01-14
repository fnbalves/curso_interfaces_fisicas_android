
int pin_button_1 = 2;
int pin_button_2 = 3;

void setup() {
  pinMode(pin_button_1, INPUT);
  pinMode(pin_button_2, INPUT);
  
  Serial.begin(9600);

}

void loop() {
  int val_button_1 = digitalRead(pin_button_1);
  int val_button_2 = digitalRead(pin_button_2);
  
  if(val_button_1==0){
    Serial.print("A");
    delay(1000);
  }

  if(val_button_2==0){
    Serial.print("B");
    delay(1000);
  }
}
