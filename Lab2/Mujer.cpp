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
  SharedMemory<int> em("/esperaMujer");
  SharedMemory<int> eh("/esperaHombr");
  SimpleSemaphore m("/mujeres");
  SimpleSemaphore h("/hombres");
  SimpleSemaphore sc("/seccionCritica");
  
  int &enBanho = eb(); // El valor inicial por defecto es 0
  int &esperaMujer = em();
  int &esperaHombre = eh();
  int PID = getpid();

  sc.Wait();
  if(enBanho >= 0){   // La mujer puede entrar
    enBanho++;
    cout << "Mujer " << PID << " enBanho ->  " << enBanho << endl;
  }else{
    esperaMujer++;
    cout << PID << " esperaMujer -> " << esperaMujer << endl;
    sc.Signal();

    m.Wait();

    sc.Wait();
    enBanho++;
  }
  sc.Signal();
		
  sleep(3);

  sc.Wait();
  enBanho--;
  if(enBanho == 0){
    while(esperaHombre > 0){
      h.Signal();
      esperaHombre--;
    }
  }
  sc.Signal();
  return 0;
}
