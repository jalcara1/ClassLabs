//============================================================================
// Name        : Escritor.cpp
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

#ifndef __CSTRING__
#include <cstring>
#define __CSTRING__
#endif

using std::cout;
using std::endl;

typedef char mensaje[10];

int main() {
  SharedMemory<mensaje> m("/memoria");
  SimpleSemaphore l("/lectores");
  SimpleSemaphore e("/escritores",0);

  mensaje &men = m();
  strcpy(men, "aaaaaaaaa");
  int pid = getpid();

  for (int veces = 0; veces < 20; veces++) {
    cout << pid << ": Esperando" << endl;
    e.Wait();
    l.Wait();
    for (int cont = 0; cont<9;cont++) {
      men[cont]++;
    }
    sleep(2);
    l.Signal();
    e.Signal();
    cout << pid << ": Terminé de generar." << endl;
    cout.flush();
    sleep(10);
  }

  return 0;
}
