#include <Servo.h>

Servo myServo;

void setup() {
  // put your setup code here, to run once:
  pinMode(9, OUTPUT);
  
  myServo.attach(9);
  Serial.begin(9600);
}

void loop() {
  int analog_reading = analogRead(A0);
  float servo_pos = (180.0/1023.0)*analog_reading;
  Serial.println(analog_reading);
  myServo.write((int)servo_pos);
}
