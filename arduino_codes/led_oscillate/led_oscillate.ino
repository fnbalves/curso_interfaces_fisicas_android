int current_time_down = 0;

int iter_duration = 20;
int time_change = 60;
int num_iter = time_change/iter_duration;
int count_iter = 0;

int is_increasing = 1;

void setup() {
  pinMode(LED_BUILTIN, OUTPUT);
}

void loop() {
  digitalWrite(LED_BUILTIN, HIGH);
  delay(iter_duration - current_time_down); //tempo em alta
  digitalWrite(LED_BUILTIN, LOW);
  delay(current_time_down); //tempo em baixa

  count_iter += 1;

  if(count_iter > num_iter){

    if(is_increasing){
      current_time_down += 1;
    }else{
      current_time_down -= 1;
    }

    if(current_time_down >= iter_duration){
      is_increasing = 0;
    }

    if(current_time_down <= 0){
      is_increasing = 1;
    }

    count_iter = 0;
  }
  
}
