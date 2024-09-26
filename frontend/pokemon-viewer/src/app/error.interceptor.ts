import { HttpErrorResponse, HttpInterceptorFn } from '@angular/common/http';
import { inject } from '@angular/core';
import { MatSnackBar } from '@angular/material/snack-bar';
import { catchError, throwError } from 'rxjs';

export const errorInterceptor: HttpInterceptorFn = (req, next) => {
  const snackBar = inject(MatSnackBar);
  return next(req).pipe(
    catchError((error: HttpErrorResponse) => {
      let errorMessage: string;
      if(error.status ===0){
        errorMessage = "connection error please check";

        console.log("connection error please check");
      }
      else if(error.status >= 400){
        errorMessage = "error when calling API " + error.message;
        console.log("error when calling API " + error.message);
      }else{
        errorMessage ="unknown error";
      }
      
      snackBar.open(errorMessage);
      return throwError(() => error);
    })
  );

};

