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

const int tamCola = 5;
typedef int cola_t[tamCola];

int main() {
  SimpleSemaphore sem("/sem",0);
  SimpleSemaphore sem2("/sem2",5);
  SimpleSemaphore semInsercion("/semInsercion");
  SimpleSemaphore semNumElem("/semNumElem");
  SharedMemory<cola_t> cola("/cola");
  SharedMemory<int> insercion("/insercion");
  SharedMemory<int> numElem("/numElem");

  cola_t &c = cola();
  int &i = insercion();
  int &n = numElem();

  int pid = getpid();
  for (int cont = 0; cont <6; cont++) {
    cerr << "Productor " << pid <<": Esperando por buffer" << endl;
    sem2.Wait();
    sleep(1);
    semInsercion.Wait();
    c[i] = pid;
    i = (i+1)%tamCola;
    semInsercion.Signal();
    semNumElem.Wait();
    n++;
    semNumElem.Signal();
    cout << "Productor " << pid << ": Generó en  "  << i-1 << " el valor " << pid << endl;
    sem.Signal();
  }
  return 0;
}
