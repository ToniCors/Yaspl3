; ModuleID = 'TestEser5Source.c'
source_filename = "TestEser5Source.c"
target datalayout = "e-m:e-i64:64-f80:128-n8:16:32:64-S128"
target triple = "x86_64-pc-linux-gnu"

@.str = private unnamed_addr constant [3 x i8] c"%d\00", align 1
@.str.1 = private unnamed_addr constant [3 x i8] c"%c\00", align 1
@.str.2 = private unnamed_addr constant [5 x i8] c"%.*g\00", align 1
@.str.3 = private unnamed_addr constant [4 x i8] c"%lf\00", align 1
@scelta = global i32 1, align 4
@sceltaOP = global i32 1, align 4
@operation = global i8 97, align 1
@result = global double 0.000000e+00, align 8
@.str.4 = private unnamed_addr constant [4 x i8] c"%s\0A\00", align 1
@.str.5 = private unnamed_addr constant [32 x i8] c"i numeri devono essere positivi\00", align 1
@.str.6 = private unnamed_addr constant [27 x i8] c"impossibile dividere per 0\00", align 1
@.str.7 = private unnamed_addr constant [54 x i8] c"Impossibile calcolare fibonacci di un numero negativo\00", align 1
@.str.8 = private unnamed_addr constant [163 x i8] c"Digita + per la somma\0A, - per la sottrazione\0A, * per la moltiplicazione con somme\0A, / per la divisione tra interi\0A, ^ per l'elevazione a potenza\0A, f per fibonacci\00", align 1
@.str.9 = private unnamed_addr constant [4 x i8] c"\0A%c\00", align 1
@.str.10 = private unnamed_addr constant [22 x i8] c"scelta errata riprova\00", align 1
@.str.11 = private unnamed_addr constant [23 x i8] c"Digita il primo valore\00", align 1
@.str.12 = private unnamed_addr constant [5 x i8] c"\0A%lf\00", align 1
@input1 = common global double 0.000000e+00, align 8
@.str.13 = private unnamed_addr constant [25 x i8] c"Digita il secondo valore\00", align 1
@input2 = common global double 0.000000e+00, align 8
@.str.14 = private unnamed_addr constant [13 x i8] c"Il risultato\00", align 1
@.str.15 = private unnamed_addr constant [19 x i8] c"dell addizione e':\00", align 1
@.str.16 = private unnamed_addr constant [21 x i8] c"dell sottrazione e':\00", align 1
@.str.17 = private unnamed_addr constant [25 x i8] c"dell moltiplicazione e':\00", align 1
@.str.18 = private unnamed_addr constant [19 x i8] c"dell divisione e':\00", align 1
@.str.19 = private unnamed_addr constant [17 x i8] c"dell potenza e':\00", align 1
@.str.20 = private unnamed_addr constant [17 x i8] c"di fibonacci e':\00", align 1
@.str.21 = private unnamed_addr constant [5 x i8] c"%lf\0A\00", align 1
@.str.22 = private unnamed_addr constant [46 x i8] c"Digita un numero per continuare, 0 per uscire\00", align 1
@.str.23 = private unnamed_addr constant [4 x i8] c"\0A%d\00", align 1

; Function Attrs: noinline nounwind uwtable
define i8* @concat(i8*, i8*) #0 {
  %3 = alloca i8*, align 8
  %4 = alloca i8*, align 8
  %5 = alloca i8*, align 8
  store i8* %0, i8** %3, align 8
  store i8* %1, i8** %4, align 8
  %6 = load i8*, i8** %3, align 8
  %7 = call i64 @strlen(i8* %6) #5
  %8 = load i8*, i8** %4, align 8
  %9 = call i64 @strlen(i8* %8) #5
  %10 = add i64 %7, %9
  %11 = add i64 %10, 1
  %12 = call noalias i8* @malloc(i64 %11) #4
  store i8* %12, i8** %5, align 8
  %13 = load i8*, i8** %5, align 8
  %14 = load i8*, i8** %3, align 8
  %15 = call i8* @strcpy(i8* %13, i8* %14) #4
  %16 = load i8*, i8** %5, align 8
  %17 = load i8*, i8** %4, align 8
  %18 = call i8* @strcat(i8* %16, i8* %17) #4
  %19 = load i8*, i8** %5, align 8
  ret i8* %19
}

; Function Attrs: nounwind
declare noalias i8* @malloc(i64) #1

; Function Attrs: nounwind readonly
declare i64 @strlen(i8*) #2

; Function Attrs: nounwind
declare i8* @strcpy(i8*, i8*) #1

; Function Attrs: nounwind
declare i8* @strcat(i8*, i8*) #1

; Function Attrs: noinline nounwind uwtable
define i8* @IntToString(i32) #0 {
  %2 = alloca i32, align 4
  %3 = alloca i32, align 4
  %4 = alloca i32, align 4
  %5 = alloca i8*, align 8
  %6 = alloca i8*, align 8
  store i32 %0, i32* %2, align 4
  %7 = load i32, i32* %2, align 4
  store i32 %7, i32* %3, align 4
  store i32 1, i32* %4, align 4
  br label %8

; <label>:8:                                      ; preds = %11, %1
  %9 = load i32, i32* %3, align 4
  %10 = icmp ne i32 %9, 0
  br i1 %10, label %11, label %18

; <label>:11:                                     ; preds = %8
  %12 = load i32, i32* %3, align 4
  %13 = sdiv i32 %12, 10
  store i32 %13, i32* %3, align 4
  %14 = load i32, i32* %4, align 4
  %15 = add nsw i32 %14, 1
  store i32 %15, i32* %4, align 4
  %16 = load i32, i32* %4, align 4
  %17 = call i32 (i8*, ...) @printf(i8* getelementptr inbounds ([3 x i8], [3 x i8]* @.str, i32 0, i32 0), i32 %16)
  br label %8

; <label>:18:                                     ; preds = %8
  %19 = load i32, i32* %4, align 4
  %20 = add nsw i32 %19, 1
  %21 = sext i32 %20 to i64
  %22 = mul i64 %21, 1
  %23 = call noalias i8* @malloc(i64 %22) #4
  store i8* %23, i8** %5, align 8
  %24 = load i8*, i8** %5, align 8
  %25 = call i64 @strlen(i8* %24) #5
  %26 = add i64 %25, 1
  %27 = call i8* @llvm.stacksave()
  store i8* %27, i8** %6, align 8
  %28 = alloca i8, i64 %26, align 16
  %29 = load i32, i32* %2, align 4
  %30 = call i32 (i8*, i8*, ...) @sprintf(i8* %28, i8* getelementptr inbounds ([3 x i8], [3 x i8]* @.str, i32 0, i32 0), i32 %29) #4
  %31 = load i8*, i8** %5, align 8
  %32 = call i8* @strcpy(i8* %31, i8* %28) #4
  %33 = load i8*, i8** %5, align 8
  %34 = load i8*, i8** %6, align 8
  call void @llvm.stackrestore(i8* %34)
  ret i8* %33
}

declare i32 @printf(i8*, ...) #3

; Function Attrs: nounwind
declare i8* @llvm.stacksave() #4

; Function Attrs: nounwind
declare i32 @sprintf(i8*, i8*, ...) #1

; Function Attrs: nounwind
declare void @llvm.stackrestore(i8*) #4

; Function Attrs: noinline nounwind uwtable
define i8* @CharToString(i8 signext) #0 {
  %2 = alloca i8, align 1
  %3 = alloca i8*, align 8
  %4 = alloca [2 x i8], align 1
  store i8 %0, i8* %2, align 1
  %5 = call noalias i8* @malloc(i64 2) #4
  store i8* %5, i8** %3, align 8
  %6 = getelementptr inbounds [2 x i8], [2 x i8]* %4, i32 0, i32 0
  %7 = load i8, i8* %2, align 1
  %8 = sext i8 %7 to i32
  %9 = call i32 (i8*, i8*, ...) @sprintf(i8* %6, i8* getelementptr inbounds ([3 x i8], [3 x i8]* @.str.1, i32 0, i32 0), i32 %8) #4
  %10 = load i8*, i8** %3, align 8
  %11 = getelementptr inbounds [2 x i8], [2 x i8]* %4, i32 0, i32 0
  %12 = call i8* @strcpy(i8* %10, i8* %11) #4
  %13 = load i8*, i8** %3, align 8
  ret i8* %13
}

; Function Attrs: noinline nounwind uwtable
define i8* @DoubleToString(double) #0 {
  %2 = alloca double, align 8
  %3 = alloca i8*, align 8
  %4 = alloca i32, align 4
  %5 = alloca double, align 8
  %6 = alloca i32, align 4
  %7 = alloca i32, align 4
  %8 = alloca i32, align 4
  %9 = alloca i32, align 4
  %10 = alloca double, align 8
  store double %0, double* %2, align 8
  store i32 20, i32* %4, align 4
  %11 = load double, double* %2, align 8
  %12 = load double, double* %2, align 8
  %13 = fptosi double %12 to i64
  %14 = sitofp i64 %13 to double
  %15 = fsub double %11, %14
  store double %15, double* %5, align 8
  store i32 1, i32* %6, align 4
  store i32 1, i32* %7, align 4
  store i32 10, i32* %8, align 4
  br label %16

; <label>:16:                                     ; preds = %29, %1
  %17 = load i32, i32* %8, align 4
  %18 = sitofp i32 %17 to double
  %19 = load double, double* %5, align 8
  %20 = fmul double %18, %19
  %21 = load i32, i32* %7, align 4
  %22 = sitofp i32 %21 to double
  %23 = fcmp oge double %20, %22
  br i1 %23, label %24, label %27

; <label>:24:                                     ; preds = %16
  %25 = load i32, i32* %6, align 4
  %26 = icmp sle i32 %25, 4
  br label %27

; <label>:27:                                     ; preds = %24, %16
  %28 = phi i1 [ false, %16 ], [ %26, %24 ]
  br i1 %28, label %29, label %38

; <label>:29:                                     ; preds = %27
  %30 = load i32, i32* %8, align 4
  %31 = sitofp i32 %30 to double
  %32 = load double, double* %5, align 8
  %33 = fmul double %31, %32
  store double %33, double* %5, align 8
  %34 = load i32, i32* %8, align 4
  %35 = mul nsw i32 %34, 10
  store i32 %35, i32* %8, align 4
  %36 = load i32, i32* %6, align 4
  %37 = add nsw i32 %36, 1
  store i32 %37, i32* %6, align 4
  br label %16

; <label>:38:                                     ; preds = %27
  %39 = load i32, i32* %6, align 4
  %40 = mul nsw i32 %39, 10
  %41 = sext i32 %40 to i64
  %42 = mul i64 %41, 8
  %43 = call noalias i8* @malloc(i64 %42) #4
  store i8* %43, i8** %3, align 8
  store i32 0, i32* %9, align 4
  br label %44

; <label>:44:                                     ; preds = %66, %38
  %45 = load i32, i32* %9, align 4
  %46 = load i32, i32* %6, align 4
  %47 = icmp slt i32 %45, %46
  br i1 %47, label %48, label %69

; <label>:48:                                     ; preds = %44
  %49 = load i8*, i8** %3, align 8
  %50 = load i32, i32* %4, align 4
  %51 = sext i32 %50 to i64
  %52 = load i32, i32* %9, align 4
  %53 = load double, double* %2, align 8
  %54 = call i32 (i8*, i64, i8*, ...) @snprintf(i8* %49, i64 %51, i8* getelementptr inbounds ([5 x i8], [5 x i8]* @.str.2, i32 0, i32 0), i32 %52, double %53) #4
  %55 = load i32, i32* %4, align 4
  %56 = icmp sge i32 %54, %55
  br i1 %56, label %57, label %58

; <label>:57:                                     ; preds = %48
  br label %69

; <label>:58:                                     ; preds = %48
  %59 = load i8*, i8** %3, align 8
  %60 = call i32 (i8*, i8*, ...) @__isoc99_sscanf(i8* %59, i8* getelementptr inbounds ([4 x i8], [4 x i8]* @.str.3, i32 0, i32 0), double* %10) #4
  %61 = load double, double* %10, align 8
  %62 = load double, double* %2, align 8
  %63 = fcmp oeq double %61, %62
  br i1 %63, label %64, label %65

; <label>:64:                                     ; preds = %58
  br label %69

; <label>:65:                                     ; preds = %58
  br label %66

; <label>:66:                                     ; preds = %65
  %67 = load i32, i32* %9, align 4
  %68 = add nsw i32 %67, 1
  store i32 %68, i32* %9, align 4
  br label %44

; <label>:69:                                     ; preds = %64, %57, %44
  %70 = load i8*, i8** %3, align 8
  ret i8* %70
}

; Function Attrs: nounwind
declare i32 @snprintf(i8*, i64, i8*, ...) #1

; Function Attrs: nounwind
declare i32 @__isoc99_sscanf(i8*, i8*, ...) #1

; Function Attrs: noinline nounwind uwtable
define void @addizione(double, double, double*) #0 {
  %4 = alloca double, align 8
  %5 = alloca double, align 8
  %6 = alloca double*, align 8
  store double %0, double* %4, align 8
  store double %1, double* %5, align 8
  store double* %2, double** %6, align 8
  %7 = load double*, double** %6, align 8
  store double 0.000000e+00, double* %7, align 8
  %8 = load double, double* %4, align 8
  %9 = load double, double* %5, align 8
  %10 = fadd double %8, %9
  %11 = load double*, double** %6, align 8
  store double %10, double* %11, align 8
  ret void
}

; Function Attrs: noinline nounwind uwtable
define void @sottrazione(double, double, double*) #0 {
  %4 = alloca double, align 8
  %5 = alloca double, align 8
  %6 = alloca double*, align 8
  store double %0, double* %4, align 8
  store double %1, double* %5, align 8
  store double* %2, double** %6, align 8
  %7 = load double*, double** %6, align 8
  store double 0.000000e+00, double* %7, align 8
  %8 = load double, double* %4, align 8
  %9 = load double, double* %5, align 8
  %10 = fsub double %8, %9
  %11 = load double*, double** %6, align 8
  store double %10, double* %11, align 8
  ret void
}

; Function Attrs: noinline nounwind uwtable
define void @moltiplicazione(double, double, double*) #0 {
  %4 = alloca double, align 8
  %5 = alloca double, align 8
  %6 = alloca double*, align 8
  %7 = alloca i32, align 4
  store double %0, double* %4, align 8
  store double %1, double* %5, align 8
  store double* %2, double** %6, align 8
  store i32 1, i32* %7, align 4
  %8 = load double*, double** %6, align 8
  store double 0.000000e+00, double* %8, align 8
  br label %9

; <label>:9:                                      ; preds = %14, %3
  %10 = load i32, i32* %7, align 4
  %11 = sitofp i32 %10 to double
  %12 = load double, double* %5, align 8
  %13 = fcmp ole double %11, %12
  br i1 %13, label %14, label %22

; <label>:14:                                     ; preds = %9
  %15 = load double*, double** %6, align 8
  %16 = load double, double* %15, align 8
  %17 = load double, double* %4, align 8
  %18 = fadd double %16, %17
  %19 = load double*, double** %6, align 8
  store double %18, double* %19, align 8
  %20 = load i32, i32* %7, align 4
  %21 = add nsw i32 %20, 1
  store i32 %21, i32* %7, align 4
  br label %9

; <label>:22:                                     ; preds = %9
  ret void
}

; Function Attrs: noinline nounwind uwtable
define void @divisione(double, double, double*) #0 {
  %4 = alloca double, align 8
  %5 = alloca double, align 8
  %6 = alloca double*, align 8
  store double %0, double* %4, align 8
  store double %1, double* %5, align 8
  store double* %2, double** %6, align 8
  %7 = load double*, double** %6, align 8
  store double 0.000000e+00, double* %7, align 8
  %8 = load double, double* %4, align 8
  %9 = fcmp olt double %8, 0.000000e+00
  br i1 %9, label %13, label %10

; <label>:10:                                     ; preds = %3
  %11 = load double, double* %5, align 8
  %12 = fcmp olt double %11, 0.000000e+00
  br i1 %12, label %13, label %16

; <label>:13:                                     ; preds = %10, %3
  %14 = call i32 (i8*, ...) @printf(i8* getelementptr inbounds ([4 x i8], [4 x i8]* @.str.4, i32 0, i32 0), i8* getelementptr inbounds ([32 x i8], [32 x i8]* @.str.5, i32 0, i32 0))
  %15 = load double*, double** %6, align 8
  store double 0.000000e+00, double* %15, align 8
  br label %28

; <label>:16:                                     ; preds = %10
  %17 = load double, double* %5, align 8
  %18 = fcmp oeq double %17, 0.000000e+00
  br i1 %18, label %19, label %22

; <label>:19:                                     ; preds = %16
  %20 = call i32 (i8*, ...) @printf(i8* getelementptr inbounds ([4 x i8], [4 x i8]* @.str.4, i32 0, i32 0), i8* getelementptr inbounds ([27 x i8], [27 x i8]* @.str.6, i32 0, i32 0))
  %21 = load double*, double** %6, align 8
  store double 0.000000e+00, double* %21, align 8
  br label %27

; <label>:22:                                     ; preds = %16
  %23 = load double, double* %4, align 8
  %24 = load double, double* %5, align 8
  %25 = fdiv double %23, %24
  %26 = load double*, double** %6, align 8
  store double %25, double* %26, align 8
  br label %27

; <label>:27:                                     ; preds = %22, %19
  br label %28

; <label>:28:                                     ; preds = %27, %13
  ret void
}

; Function Attrs: noinline nounwind uwtable
define void @potenza(double, double, double*) #0 {
  %4 = alloca double, align 8
  %5 = alloca double, align 8
  %6 = alloca double*, align 8
  %7 = alloca i32, align 4
  store double %0, double* %4, align 8
  store double %1, double* %5, align 8
  store double* %2, double** %6, align 8
  store i32 1, i32* %7, align 4
  %8 = load double*, double** %6, align 8
  store double 1.000000e+00, double* %8, align 8
  br label %9

; <label>:9:                                      ; preds = %14, %3
  %10 = load i32, i32* %7, align 4
  %11 = sitofp i32 %10 to double
  %12 = load double, double* %5, align 8
  %13 = fcmp ole double %11, %12
  br i1 %13, label %14, label %22

; <label>:14:                                     ; preds = %9
  %15 = load double*, double** %6, align 8
  %16 = load double, double* %15, align 8
  %17 = load double, double* %4, align 8
  %18 = fmul double %16, %17
  %19 = load double*, double** %6, align 8
  store double %18, double* %19, align 8
  %20 = load i32, i32* %7, align 4
  %21 = add nsw i32 %20, 1
  store i32 %21, i32* %7, align 4
  br label %9

; <label>:22:                                     ; preds = %9
  ret void
}

; Function Attrs: noinline nounwind uwtable
define void @fibonacci(i32, double*) #0 {
  %3 = alloca i32, align 4
  %4 = alloca double*, align 8
  %5 = alloca i32, align 4
  store i32 %0, i32* %3, align 4
  store double* %1, double** %4, align 8
  %6 = load i32, i32* %3, align 4
  %7 = icmp slt i32 %6, 0
  br i1 %7, label %8, label %11

; <label>:8:                                      ; preds = %2
  %9 = load double*, double** %4, align 8
  store double -1.000000e+00, double* %9, align 8
  %10 = call i32 (i8*, ...) @printf(i8* getelementptr inbounds ([4 x i8], [4 x i8]* @.str.4, i32 0, i32 0), i8* getelementptr inbounds ([54 x i8], [54 x i8]* @.str.7, i32 0, i32 0))
  br label %43

; <label>:11:                                     ; preds = %2
  %12 = load i32, i32* %3, align 4
  %13 = icmp eq i32 %12, 0
  br i1 %13, label %14, label %16

; <label>:14:                                     ; preds = %11
  %15 = load double*, double** %4, align 8
  store double 0.000000e+00, double* %15, align 8
  br label %16

; <label>:16:                                     ; preds = %14, %11
  %17 = load i32, i32* %3, align 4
  %18 = icmp eq i32 %17, 1
  br i1 %18, label %19, label %21

; <label>:19:                                     ; preds = %16
  %20 = load double*, double** %4, align 8
  store double 1.000000e+00, double* %20, align 8
  br label %21

; <label>:21:                                     ; preds = %19, %16
  %22 = load i32, i32* %3, align 4
  %23 = icmp sgt i32 %22, 1
  br i1 %23, label %24, label %42

; <label>:24:                                     ; preds = %21
  %25 = load i32, i32* %3, align 4
  %26 = sub nsw i32 %25, 1
  store i32 %26, i32* %3, align 4
  %27 = load i32, i32* %3, align 4
  %28 = load double*, double** %4, align 8
  call void @fibonacci(i32 %27, double* %28)
  %29 = load double*, double** %4, align 8
  %30 = load double, double* %29, align 8
  %31 = fptosi double %30 to i32
  store i32 %31, i32* %5, align 4
  %32 = load i32, i32* %3, align 4
  %33 = sub nsw i32 %32, 1
  store i32 %33, i32* %3, align 4
  %34 = load i32, i32* %3, align 4
  %35 = load double*, double** %4, align 8
  call void @fibonacci(i32 %34, double* %35)
  %36 = load i32, i32* %5, align 4
  %37 = sitofp i32 %36 to double
  %38 = load double*, double** %4, align 8
  %39 = load double, double* %38, align 8
  %40 = fadd double %37, %39
  %41 = load double*, double** %4, align 8
  store double %40, double* %41, align 8
  br label %42

; <label>:42:                                     ; preds = %24, %21
  br label %43

; <label>:43:                                     ; preds = %42, %8
  ret void
}

; Function Attrs: noinline nounwind uwtable
define i32 @main() #0 {
  %1 = alloca i32, align 4
  store i32 0, i32* %1, align 4
  br label %2

; <label>:2:                                      ; preds = %97, %0
  %3 = load i32, i32* @scelta, align 4
  %4 = icmp ne i32 %3, 0
  br i1 %4, label %5, label %102

; <label>:5:                                      ; preds = %2
  br label %6

; <label>:6:                                      ; preds = %38, %5
  %7 = load i32, i32* @sceltaOP, align 4
  %8 = icmp ne i32 %7, 0
  br i1 %8, label %9, label %39

; <label>:9:                                      ; preds = %6
  %10 = call i32 (i8*, ...) @printf(i8* getelementptr inbounds ([4 x i8], [4 x i8]* @.str.4, i32 0, i32 0), i8* getelementptr inbounds ([163 x i8], [163 x i8]* @.str.8, i32 0, i32 0))
  %11 = call i32 (i8*, ...) @__isoc99_scanf(i8* getelementptr inbounds ([4 x i8], [4 x i8]* @.str.9, i32 0, i32 0), i8* @operation)
  %12 = load i8, i8* @operation, align 1
  %13 = sext i8 %12 to i32
  %14 = icmp eq i32 %13, 43
  br i1 %14, label %37, label %15

; <label>:15:                                     ; preds = %9
  %16 = load i8, i8* @operation, align 1
  %17 = sext i8 %16 to i32
  %18 = icmp eq i32 %17, 45
  br i1 %18, label %37, label %19

; <label>:19:                                     ; preds = %15
  %20 = load i8, i8* @operation, align 1
  %21 = sext i8 %20 to i32
  %22 = icmp eq i32 %21, 42
  br i1 %22, label %37, label %23

; <label>:23:                                     ; preds = %19
  %24 = load i8, i8* @operation, align 1
  %25 = sext i8 %24 to i32
  %26 = icmp eq i32 %25, 94
  br i1 %26, label %37, label %27

; <label>:27:                                     ; preds = %23
  %28 = load i8, i8* @operation, align 1
  %29 = sext i8 %28 to i32
  %30 = icmp eq i32 %29, 102
  br i1 %30, label %37, label %31

; <label>:31:                                     ; preds = %27
  %32 = load i8, i8* @operation, align 1
  %33 = sext i8 %32 to i32
  %34 = icmp eq i32 %33, 47
  br i1 %34, label %37, label %35

; <label>:35:                                     ; preds = %31
  store i32 1, i32* @sceltaOP, align 4
  %36 = call i32 (i8*, ...) @printf(i8* getelementptr inbounds ([4 x i8], [4 x i8]* @.str.4, i32 0, i32 0), i8* getelementptr inbounds ([22 x i8], [22 x i8]* @.str.10, i32 0, i32 0))
  br label %38

; <label>:37:                                     ; preds = %31, %27, %23, %19, %15, %9
  store i32 0, i32* @sceltaOP, align 4
  br label %38

; <label>:38:                                     ; preds = %37, %35
  br label %6

; <label>:39:                                     ; preds = %6
  %40 = call i32 (i8*, ...) @printf(i8* getelementptr inbounds ([4 x i8], [4 x i8]* @.str.4, i32 0, i32 0), i8* getelementptr inbounds ([23 x i8], [23 x i8]* @.str.11, i32 0, i32 0))
  %41 = call i32 (i8*, ...) @__isoc99_scanf(i8* getelementptr inbounds ([5 x i8], [5 x i8]* @.str.12, i32 0, i32 0), double* @input1)
  %42 = load i8, i8* @operation, align 1
  %43 = sext i8 %42 to i32
  %44 = icmp eq i32 %43, 102
  br i1 %44, label %48, label %45

; <label>:45:                                     ; preds = %39
  %46 = call i32 (i8*, ...) @printf(i8* getelementptr inbounds ([4 x i8], [4 x i8]* @.str.4, i32 0, i32 0), i8* getelementptr inbounds ([25 x i8], [25 x i8]* @.str.13, i32 0, i32 0))
  %47 = call i32 (i8*, ...) @__isoc99_scanf(i8* getelementptr inbounds ([5 x i8], [5 x i8]* @.str.12, i32 0, i32 0), double* @input2)
  br label %48

; <label>:48:                                     ; preds = %45, %39
  %49 = call i32 (i8*, ...) @printf(i8* getelementptr inbounds ([4 x i8], [4 x i8]* @.str.4, i32 0, i32 0), i8* getelementptr inbounds ([13 x i8], [13 x i8]* @.str.14, i32 0, i32 0))
  %50 = load i8, i8* @operation, align 1
  %51 = sext i8 %50 to i32
  %52 = icmp eq i32 %51, 43
  br i1 %52, label %53, label %57

; <label>:53:                                     ; preds = %48
  %54 = load double, double* @input1, align 8
  %55 = load double, double* @input2, align 8
  call void @addizione(double %54, double %55, double* @result)
  %56 = call i32 (i8*, ...) @printf(i8* getelementptr inbounds ([4 x i8], [4 x i8]* @.str.4, i32 0, i32 0), i8* getelementptr inbounds ([19 x i8], [19 x i8]* @.str.15, i32 0, i32 0))
  br label %57

; <label>:57:                                     ; preds = %53, %48
  %58 = load i8, i8* @operation, align 1
  %59 = sext i8 %58 to i32
  %60 = icmp eq i32 %59, 45
  br i1 %60, label %61, label %65

; <label>:61:                                     ; preds = %57
  %62 = load double, double* @input1, align 8
  %63 = load double, double* @input2, align 8
  call void @sottrazione(double %62, double %63, double* @result)
  %64 = call i32 (i8*, ...) @printf(i8* getelementptr inbounds ([4 x i8], [4 x i8]* @.str.4, i32 0, i32 0), i8* getelementptr inbounds ([21 x i8], [21 x i8]* @.str.16, i32 0, i32 0))
  br label %65

; <label>:65:                                     ; preds = %61, %57
  %66 = load i8, i8* @operation, align 1
  %67 = sext i8 %66 to i32
  %68 = icmp eq i32 %67, 42
  br i1 %68, label %69, label %73

; <label>:69:                                     ; preds = %65
  %70 = load double, double* @input1, align 8
  %71 = load double, double* @input2, align 8
  call void @moltiplicazione(double %70, double %71, double* @result)
  %72 = call i32 (i8*, ...) @printf(i8* getelementptr inbounds ([4 x i8], [4 x i8]* @.str.4, i32 0, i32 0), i8* getelementptr inbounds ([25 x i8], [25 x i8]* @.str.17, i32 0, i32 0))
  br label %73

; <label>:73:                                     ; preds = %69, %65
  %74 = load i8, i8* @operation, align 1
  %75 = sext i8 %74 to i32
  %76 = icmp eq i32 %75, 47
  br i1 %76, label %77, label %81

; <label>:77:                                     ; preds = %73
  %78 = load double, double* @input1, align 8
  %79 = load double, double* @input2, align 8
  call void @divisione(double %78, double %79, double* @result)
  %80 = call i32 (i8*, ...) @printf(i8* getelementptr inbounds ([4 x i8], [4 x i8]* @.str.4, i32 0, i32 0), i8* getelementptr inbounds ([19 x i8], [19 x i8]* @.str.18, i32 0, i32 0))
  br label %81

; <label>:81:                                     ; preds = %77, %73
  %82 = load i8, i8* @operation, align 1
  %83 = sext i8 %82 to i32
  %84 = icmp eq i32 %83, 94
  br i1 %84, label %85, label %89

; <label>:85:                                     ; preds = %81
  %86 = load double, double* @input1, align 8
  %87 = load double, double* @input2, align 8
  call void @potenza(double %86, double %87, double* @result)
  %88 = call i32 (i8*, ...) @printf(i8* getelementptr inbounds ([4 x i8], [4 x i8]* @.str.4, i32 0, i32 0), i8* getelementptr inbounds ([17 x i8], [17 x i8]* @.str.19, i32 0, i32 0))
  br label %89

; <label>:89:                                     ; preds = %85, %81
  %90 = load i8, i8* @operation, align 1
  %91 = sext i8 %90 to i32
  %92 = icmp eq i32 %91, 102
  br i1 %92, label %93, label %97

; <label>:93:                                     ; preds = %89
  %94 = load double, double* @input1, align 8
  %95 = fptosi double %94 to i32
  call void @fibonacci(i32 %95, double* @result)
  %96 = call i32 (i8*, ...) @printf(i8* getelementptr inbounds ([4 x i8], [4 x i8]* @.str.4, i32 0, i32 0), i8* getelementptr inbounds ([17 x i8], [17 x i8]* @.str.20, i32 0, i32 0))
  br label %97

; <label>:97:                                     ; preds = %93, %89
  %98 = load double, double* @result, align 8
  %99 = call i32 (i8*, ...) @printf(i8* getelementptr inbounds ([5 x i8], [5 x i8]* @.str.21, i32 0, i32 0), double %98)
  store i32 1, i32* @sceltaOP, align 4
  %100 = call i32 (i8*, ...) @printf(i8* getelementptr inbounds ([4 x i8], [4 x i8]* @.str.4, i32 0, i32 0), i8* getelementptr inbounds ([46 x i8], [46 x i8]* @.str.22, i32 0, i32 0))
  %101 = call i32 (i8*, ...) @__isoc99_scanf(i8* getelementptr inbounds ([4 x i8], [4 x i8]* @.str.23, i32 0, i32 0), i32* @scelta)
  store double 0.000000e+00, double* @result, align 8
  br label %2

; <label>:102:                                    ; preds = %2
  ret i32 0
}

declare i32 @__isoc99_scanf(i8*, ...) #3

attributes #0 = { noinline nounwind uwtable "correctly-rounded-divide-sqrt-fp-math"="false" "disable-tail-calls"="false" "less-precise-fpmad"="false" "no-frame-pointer-elim"="true" "no-frame-pointer-elim-non-leaf" "no-infs-fp-math"="false" "no-jump-tables"="false" "no-nans-fp-math"="false" "no-signed-zeros-fp-math"="false" "no-trapping-math"="false" "stack-protector-buffer-size"="8" "target-cpu"="x86-64" "target-features"="+fxsr,+mmx,+sse,+sse2,+x87" "unsafe-fp-math"="false" "use-soft-float"="false" }
attributes #1 = { nounwind "correctly-rounded-divide-sqrt-fp-math"="false" "disable-tail-calls"="false" "less-precise-fpmad"="false" "no-frame-pointer-elim"="true" "no-frame-pointer-elim-non-leaf" "no-infs-fp-math"="false" "no-nans-fp-math"="false" "no-signed-zeros-fp-math"="false" "no-trapping-math"="false" "stack-protector-buffer-size"="8" "target-cpu"="x86-64" "target-features"="+fxsr,+mmx,+sse,+sse2,+x87" "unsafe-fp-math"="false" "use-soft-float"="false" }
attributes #2 = { nounwind readonly "correctly-rounded-divide-sqrt-fp-math"="false" "disable-tail-calls"="false" "less-precise-fpmad"="false" "no-frame-pointer-elim"="true" "no-frame-pointer-elim-non-leaf" "no-infs-fp-math"="false" "no-nans-fp-math"="false" "no-signed-zeros-fp-math"="false" "no-trapping-math"="false" "stack-protector-buffer-size"="8" "target-cpu"="x86-64" "target-features"="+fxsr,+mmx,+sse,+sse2,+x87" "unsafe-fp-math"="false" "use-soft-float"="false" }
attributes #3 = { "correctly-rounded-divide-sqrt-fp-math"="false" "disable-tail-calls"="false" "less-precise-fpmad"="false" "no-frame-pointer-elim"="true" "no-frame-pointer-elim-non-leaf" "no-infs-fp-math"="false" "no-nans-fp-math"="false" "no-signed-zeros-fp-math"="false" "no-trapping-math"="false" "stack-protector-buffer-size"="8" "target-cpu"="x86-64" "target-features"="+fxsr,+mmx,+sse,+sse2,+x87" "unsafe-fp-math"="false" "use-soft-float"="false" }
attributes #4 = { nounwind }
attributes #5 = { nounwind readonly }

!llvm.ident = !{!0}

!0 = !{!"clang version 4.0.1-8 (tags/RELEASE_401/final)"}
