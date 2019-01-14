#include "Timer.h"

Timer t;

void printSomething(){
  Serial.println("Um segundo");
}
void setup() {
  Serial.begin(9600);
  t.every(1000, printSomething);
}

void loop() {
  t.update();
}

