# Proyecto Final Tópicos en Ingeniería de Telemática 
   ### Identificacion de placas de vehiculo en tiempo real
  
  # Integrantes del grupo:
  * Alejandro Cordoba Bodhert 
  * Juan Pablo Alcaraz Flórez 
  * Craig David Cartagena 


  ## DESCRIPCION DEL PROYECTO
  El proyecto consiste en identificar placas de vehiculos colombianos en tiempo real.A traves de una camara.

  ## TECNOLOGIAS

   - OPENCV: es una biblioteca libre de visión artificial originalmente desarrollada por Intel. ``` https://opencv.org/ ```
   
   - PYTHON: es un lenguaje de programación interpretado cuya filosofía hace hincapié en una sintaxis que favorezca un código legible. ``` https://www.python.org/ ```
   
   - AWS BUCKET: Amazon S3 es un almacenamiento en la nube para Internet. Para poder cargar sus datos (fotos, vídeos, documentos, etc.) primero ha de crear un bucket en una de las regiones de AWS. Luego puede cargar la cantidad de objetos que desee en el bucket.  ``` https://docs.aws.amazon.com/es_es/AmazonS3/latest/dev/UsingBucket.html  ```
   
   - AWS TEXT RECOGNITION: Amazon Rekognition Text in Image puede detectar texto en imágenes y convertirlo en texto legible por máquina. ``` https://docs.aws.amazon.com/rekognition/latest/dg/text-detection.html ```
   
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
