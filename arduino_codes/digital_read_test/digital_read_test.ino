int pin_read = 2;
int last_state_button = 1;

void setup() {
  // put your setup code here, to run once:
  Serial.begin(9600);
  pinMode(pin_read, INPUT);
}

void loop() {
  // put your main code here, to run repeatedly:
  int reading = digitalRead(pin_read);

  if(reading == 0){

    if(reading != last_state_button){
      Serial.println("Apertou");
      delay(10);
    }
  }

  last_state_button = reading;
}
