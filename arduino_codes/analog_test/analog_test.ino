float a = 0.2639;
float b = 0.0;

void setup() {
  // put your setup code here, to run once:
  Serial.begin(9600);
}

void loop() {
  // put your main code here, to run repeatedly:
  int analog_reading = analogRead(0);
  float ang = a*float(analog_reading) + b;
  
  Serial.println(ang, DEC);
  delay(100);
}
