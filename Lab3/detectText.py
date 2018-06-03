import boto3
import re

s3=boto3.resource('s3')

if __name__ == "__main__":

    bucket='telematicaequipo3'
    s3=boto3.resource('s3')
    photo='placa1.jpeg'
    

    client=boto3.client('rekognition')
    s3.meta.client.upload_file(photo, bucket, photo)

  
    response=client.detect_text(Image={'S3Object':{'Bucket':bucket,'Name':photo}})

                        
    textDetections=response['TextDetections']
    print (response)
    print ('Matching faces')
    for text in textDetections:
            #matcher.group();
            print ('Detected text:' + text['DetectedText'])
            print ('Confidence: ' + "{:.2f}".format(text['Confidence']) + "%")
            cadena = text['DetectedText']
            patron = re.compile('([A-Z])\w') 
            matcher = patron.search('QGU')
            print(matcher.group(0))
            #print ('Id: {}'.format(text['Id']))
            #if 'ParentId' in text:
                #print ('Parent Id: {}'.format(text['ParentId']))
            #print ('Type:' + text['Type'])
            #print ()
            #print ("La placa del carro es: ")