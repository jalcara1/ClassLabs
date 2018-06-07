# Proyecto Final Tópicos en Ingeniería de Telemática 
   ### Identificacion de placas de vehiculo en tiempo real
  
  Integrantes del grupo:
  * Alejandro Cordoba Bodhert 
  * Juan Pablo Alcaraz Flórez 
  * Craig David Cartagena 


  ## DESCRIPCION DEL PROYECTO
  El proyecto consiste en identificar placas de vehiculos colombianos en tiempo real. donde a traves de una webcam.

  ## TECNOLOGIAS

   OPENCV
   PYTHON
   AWS BUCKET
   AWS TEXT RECOGNITION
   
   ## EJECUCION
   
   se debe tener la webcam conectada al computador, con referencia al puerto al cual esta conectado.
   

  ``` $ python3 LicensePlateRecognition.py  ```


   ## Dependencias

   Se requiere la instalación por medio del manejador de paquetes de Python, pip; diferentes bibliotecas requeridas para el correcto funcionamiento de la Script.
   
   - $ pip3 install multiprocessing
   - $ pip3 install boto3
   - $ pip3 install csv2
   - $ pip3 install re
   - $ pip3 install json

   ## Funcionamiento
   
   - Se identifica en la webcam vehiculos que se esten movilizando en tiempo real
   - Al indentificar un vehiculo toma la foto del vehiculo
   - Al tener la foto del vehiculo, se va identificar rectangulos en dicha foto.
   - Se reconocen los rectangulos, se le aplica el text recognition de aws a los rectangulos detectados en la imagen.
   - Con la expresiones regulares ('([A-Z][A-Z][A-Z] [0-9][0-9][0-9])\Z') y ('([A-Z][A-Z][A-Z]-[0-9][0-9][0-9])\Z') se limita al reconocimiento de texto que identifique las placas
   - Por ultimo, se utiliza un metodo que encuentre similitudes con la expresion regular.

   Para la correcta eliminación de los Stop-Words y hacer Steamming se requiere hacer la correspondiente tokenización de los datos de entrada.

   ### Vectorización del Dataset

   La transformación del texto en vectores de numeros identificables se realiza una relación entre TF (Time Frecuency) y IDF(Inverse Document Frequency)   

   * TF-IDF (Term Frequency – Inverse Document Frequency): Es un método de vectorización
  de características ampliamente utilizado en la minería de textos para reflejar la
  importancia de un término para un documento

 El calculo del TF es solo contar las ocurrencias de una palabra en un documento.

 Para calcular el IDF se utiliza la sigiente formula:

 ![Tech](/formula.png)

 Después de calcular ésto se procede a calcular el TF-IDF de la siguiente manera:
 ![Tech](/tf.png)

   ### Modelo

   Se utilizó el algoritmo de Random Forest suministrado por la biblioteca MLlib, siendo éste una combinación de árboles predictores, tal que cada árbol depende de los valores de un vector aleatorio probado independientemente y con la misma distribución para cada uno de estos.

   ![Tech](/randomForest.jpg)  

## Referencias

https://docs.opencv.org/3.0-beta/doc/py_tutorials/py_gui/py_video_display/py_video_display.html
