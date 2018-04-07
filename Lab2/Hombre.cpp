//============================================================================
// Name        : Lector.cpp
// Author      : 
// Version     :
// Copyright   : Your copyright notice
// Description : Hello World in C++, Ansi-style
//============================================================================

#ifndef __SIMPLESEMAPHORE_H_
#include <SimpleSemaphore.h>
#define __SIMPLESEMAPHORE_H_
#endif

#ifndef __SHAREDMEMORY_H_
#include <SharedMemory.h>
#define __SHAREDMEMORY_H_
#endif

#ifndef __IOSTREAM__
#include <iostream>
#define __IOSTREAM__
#endif

using std::cout;
using std::endl;

int main(){
  SharedMemory<int> eb("/enBanho");
  SharedMemory<int> eh("/esperaHombre");
  SharedMemory<int> em("/esperaMujer");
  SimpleSemaphore m("/mujeres");
  SimpleSemaphore h("/hombres");
  SimpleSemaphore sc("/seccionCritica");

  int &enBanho = eb(); // El valor inicial por defecto es 0
  int &esperaHombre = eh();
  int &esperaMujer = em();
  int PID = getpid();

  sc.Wait();
  if(enBanho >= 0){   // El hombre puede entrar
    enBanho++;
    cout << "Hombre " << PID << " enBanho -> " << enBanho<< endl;
  }else{
    esperaHombre++;
    cout << PID << " esperaHombre -> " << esperaHombre << endl;
    sc.Signal();
      
    h.Wait();

    sc.Wait();
    enBanho++;
  }
  sc.Signal();
		
  sleep(3);

  sc.Wait();
  enBanho--;
  if(enBanho == 0){
    while(esperaMujer > 0){
      m.Signal();
      esperaMujer--;
    }
  }
  sc.Signal();
  return 0;
}
