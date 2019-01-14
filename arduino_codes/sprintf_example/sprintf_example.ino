char buffer[256];

void setup() {
  // put your setup code here, to run once:
  Serial.begin(9600);
}

void loop() {
  int num1 = 2;
  int num2 = 3;
  
  // put your main code here, to run repeatedly:
  sprintf(buffer, "I%d:%dF", num1, num2, f);

  Serial.println(String(buffer));
  delay(1000);
}
