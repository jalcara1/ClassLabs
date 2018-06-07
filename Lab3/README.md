# Proyecto Final Tópicos en Ingeniería de Telemática 
   ### Identificacion de placas de vehiculo en tiempo real
  
  Integrantes del grupo:
  * Alejandro Cordoba Bodhert 
  * Juan Pablo Alcaraz Flórez 
  * Craig David Cartagena 


  ## DESCRIPCION DEL PROYECTO
  El proyecto consiste en identificar placas de vehiculos colombianos en tiempo real. donde a traves de una webcam.

  ## TECNOLOGIAS

   - OPENCV
   - PYTHON
   - AWS BUCKET
   - AWS TEXT RECOGNITION
   
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

   
## Referencias

https://docs.opencv.org/3.0-beta/doc/py_tutorials/py_gui/py_video_display/py_video_display.html
