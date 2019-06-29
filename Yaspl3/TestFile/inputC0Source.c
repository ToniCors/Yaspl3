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


int a= 10;
double b= 10.5;
char c= 'c';
char *s= "str";
bool h= BooleanConst [booleanConst=true]
;
char *str;

 void funct( int s, double c, char *b, string *a){
int aa= 100;

char *ss= concat(IntToString(aa) , *a);

( s= h);

}

 void funct1(){
int a= 100;

char *s= concat(s ,IntToString( a));

}

int main(void) { 


( str= concat(s , s));
if((strcmp(str,s)<0)){
printf("%s\n"," cancatenezaione eseguita con successo");
printf("%s\n",str);


}

( str= concat(s ,CharToString( c)));
if((strcmp(str,s)<0)){
printf("%s\n"," cancatenezaione eseguita con successo");
printf("%s\n",str);


}

( str= concat(s ,DoubleToString( b)));
if((strcmp(str,s)<0)){
printf("%s\n"," cancatenezaione eseguita con successo");
printf("%s\n",str);


}

( str= concat(s ,IntToString( a)));
if((strcmp(str,s)<0)){
printf("%s\n"," cancatenezaione eseguita con successo");
printf("%s\n",str);


}



return 0; 
}