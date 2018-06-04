import boto3
import re
import json

s3=boto3.resource('s3')

if __name__ == "__main__":

    bucket='telematicaequipo3'
    s3=boto3.resource('s3')
    photo='placa1.jpeg'
    

    client=boto3.client('rekognition')
    s3.meta.client.upload_file(photo, bucket, photo)

  
    response=client.detect_text(Image={'S3Object':{'Bucket':bucket,'Name':photo}})

                        
    textDetections=response['TextDetections']
    #print (response)
    #print ('Matching faces')
    #print (json.dumps(response,indent=4, sort_keys=True))
    for text in textDetections:
            #matcher.group();
            #print ('Detected text:' + text['DetectedText'])
            #print ('Confidence: ' + "{:.2f}".format(text['Confidence']) + "%")
            cadena = text['DetectedText']
            #print(cadena)
            patron = re.compile('([A-Z][A-Z][A-Z] [0-9][0-9][0-9])\Z')
            patron2 = re.compile('([A-Z][A-Z][A-Z]-[0-9][0-9][0-9])\Z')
            if patron.match(cadena) or patron2.match(cadena):
                print("La placa que detecto fue: " + cadena)
            #print(matcher.group(0))
            #print ('Id: {}'.format(text['Id']))
            #if 'ParentId' in text:
                #print ('Parent Id: {}'.format(text['ParentId']))
            #print ('Type:' + text['Type'])
            #print ()
            #print ("La placa del carro es: ")