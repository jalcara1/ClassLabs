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
typedef int cola_t[5];

int main() {
  SimpleSemaphore sem("/sem",0);
  SimpleSemaphore sem2("/sem2",5);
  SimpleSemaphore semBorrado("/semBorrado");
  SimpleSemaphore semNumElem("/semNumElem");
  SharedMemory<cola_t> cola("/cola");
  SharedMemory<int> borrado("/borrado");
  SharedMemory<int> numElem("/numElem");
  cola_t &c = cola();
  int &b = borrado();
  int &n = numElem();

  int pid = getpid();

  for (int cont = 0; cont < 6; cont++) {
    cerr << "Consumidor " << pid  << ": Esperando que termine el productor" << endl;
    sem.Wait();
    sleep(1);
    cerr << "Consumidor " << pid  << ": Iniciando consumo" << endl;
    semBorrado.Wait();
    cout << "Consumidor " << pid  << ": El valor recibido en " << b << " es " << c[b] << endl;
    b = (b+1)%tamCola;
    semBorrado.Signal();
    semNumElem.Wait();
    n--;
    semNumElem.Signal();
    sem2.Signal();
  }
  return 0;
}
