#include<stdio.h>
#include<stdlib.h>
#include<string.h>
#include<stdbool.h>

char* concat(const char *s1, const char *s2){
char *result = malloc(strlen(s1) + strlen(s2) + 1);
strcpy(result, s1);
strcat(result, s2);
return result;}


char* IntToString(int i){
 int temp= i, count=1;
while (temp!=0){ temp/=10; count++; printf("%d", count);}
char * buffer_temp = malloc ((count+1) * sizeof(char));
char buffer [strlen(buffer_temp) +1];
sprintf(buffer, "%d", i);
strcpy(buffer_temp, buffer);
return buffer_temp;}


char* CharToString(char c) {
 char * buffer_temp = malloc ((2) * sizeof(char));
char buffer [2];
sprintf(buffer, "%c", c);
strcpy(buffer_temp, buffer);
return buffer_temp;
}

char* DoubleToString(double d) {
char * buf;
int n=20;
double fraction = d - ((long)d);
int number_of_decimal_digits=1, limit=1;
int power=10;
while(power*fraction >= limit && number_of_decimal_digits<=4){
fraction = power*fraction; power*=10; number_of_decimal_digits++;
}
int p;
buf= malloc (number_of_decimal_digits*10 * sizeof(double));
for (p = 0; p < number_of_decimal_digits; p++) {
double x;
if (snprintf(buf, n, "%.*g", p, d) >= n) break;
sscanf(buf, "%lf", &x);
if (x == d) break;
}
return buf;
}


int scelta= 1;
int sceltaOP= 1;
char operation= 'a';
double input1;
double input2;
double result= 0;

 void addizione( double input1, double input2, double *result){
( *result= 0);

( *result= (input1 + input2));

}

 void sottrazione( double input1, double input2, double *result){
( *result= 0);

( *result= (input1 - input2));

}

 void moltiplicazione( double input1, double input2, double *result){
int i= 1;

( *result= 0);

while((i <= input2)){
( *result= (*result + input1));

( i= (i + 1));


}


}

 void divisione( double input1, double input2, double *result){
( *result= 0);

if(((input1 < 0) || (input2 < 0))){
printf("%s\n","i numeri devono essere positivi");

( *result= 0);


}else{
if((input2 == 0)){
printf("%s\n","impossibile dividere per 0");

( *result= 0);


}else{
( *result= (input1 / input2));


}



}


}

 void potenza( double input1, double input2, double *result){
int i= 1;

( *result= 1);

while((i <= input2)){
( *result= (*result * input1));

( i= (i + 1));


}


}

 void fibonacci( int input1, double *result){
int temp;

if((input1 < 0)){
( *result= -(1));

printf("%s\n","Impossibile calcolare fibonacci di un numero negativo");


}else{
if((input1 == 0)){
( *result= 0);


}


if((input1 == 1)){
( *result= 1);


}


if((input1 > 1)){
( input1= (input1 - 1));

fibonacci(input1,&*result);
( temp= *result);

( input1= (input1 - 1));

fibonacci(input1,&*result);
( *result= (temp + *result));


}



}


}

int main(void) { 


while(scelta){
while(sceltaOP){
printf("%s\n","Digita + per la somma\n, - per la sottrazione\n, * per la moltiplicazione con somme\n, / per la divisione tra interi\n, ^ per l'elevazione a potenza\n, f per fibonacci");

scanf("\n%c", &operation);
if((((((!((operation == '+')) && !((operation == '-'))) && !((operation == '*'))) && !((operation == '^'))) && !((operation == 'f'))) && !((operation == '/')))){
( sceltaOP= 1);

printf("%s\n","scelta errata riprova");


}else{
( sceltaOP= 0);


}



}


printf("%s\n","Digita il primo valore");

scanf("\n%lf", &input1);
if(!((operation == 'f'))){
printf("%s\n","Digita il secondo valore");

scanf("\n%lf", &input2);

}


printf("%s\n","Il risultato");

if((operation == '+')){
addizione(input1,input2,&result);
printf("%s\n","dell addizione e':");


}


if((operation == '-')){
sottrazione(input1,input2,&result);
printf("%s\n","dell sottrazione e':");


}


if((operation == '*')){
moltiplicazione(input1,input2,&result);
printf("%s\n","dell moltiplicazione e':");


}


if((operation == '/')){
divisione(input1,input2,&result);
printf("%s\n","dell divisione e':");


}


if((operation == '^')){
potenza(input1,input2,&result);
printf("%s\n","dell potenza e':");


}


if((operation == 'f')){
fibonacci(input1,&result);
printf("%s\n","di fibonacci e':");


}


printf("%lf\n",result);

( sceltaOP= 1);

printf("%s\n","Digita un numero per continuare, 0 per uscire");

scanf("\n%d", &scelta);
( result= 0);


}



return 0; 
}