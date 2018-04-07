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

typedef char mensaje[10];

int main() {
  SharedMemory<mensaje> m("/memoria");
  SharedMemory<int> nl("/numLectores");
  SimpleSemaphore l("/lectores");
  SimpleSemaphore e("/escritores");
  SimpleSemaphore sc("/seccionCritica");

  mensaje &men = m();
  int &numLectores = nl();
  int pid = getpid();
  mensaje buffer;

  for (int veces = 0; veces < 100; veces++) {
    e.Wait();
    sc.Wait();
    if (numLectores == 0) {
      l.Wait();
    }
    numLectores++;
    sc.Signal();
    e.Signal();
    strcpy(buffer, men);
    sleep(1);
    sc.Wait();
    numLectores--;
    if (numLectores == 0) {
      l.Signal();
    }
    sc.Signal();
    cout << pid << ": " << buffer << endl;
    cout.flush();
  }

  return 0;
}
