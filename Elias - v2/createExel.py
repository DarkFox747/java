import os
from scritp1 import*
import pandas as pd

columnas = ['Tipo_certificado', 'Fecha', 'Manifiesto', 'Generador', 'Transportista', 'Operador', 'Tipo_Residuo', 'kilos_Residuo']
df = pd.DataFrame(columns=columnas)
carpeta = "data"
archivos_txt = [archivo for archivo in os.listdir(carpeta) if archivo.endswith('.txt')]

for archivo in archivos_txt:
    ruta_archivo = os.path.join(carpeta, archivo)
    if os.path.exists(ruta_archivo):
        try:
            # Abre el archivo en modo lectura ('r')
            with open(ruta_archivo, 'r', encoding='utf-8') as archivo_txt:
                # Lee y muestra el contenido del archivo
                contenido = archivo_txt.read()
                tipo_certificado = extraer_destino_residuo(contenido)
                if tipo_certificado == "Disposicion Final":
                    tipo_certificado = "Operacion"
                else:
                    tipo_certificado = "Tratamiento"
                fecha = extraer_fecha(contenido)
                numero = extraer_numero(contenido)
                generador =  extraer_razon_social(contenido)
                transportista = extraer_razon_social_transportista(contenido)
                operador = extraer_razon_social_destino(contenido)
                tipoResiduo = extraer_categoria_y_cantidad(contenido)
                kilosResiduo = kilos(contenido)
                for i in range(len(tipoResiduo)):
                     nueva_fila = {
                                    'Tipo_certificado': tipo_certificado,
                                    'Fecha': fecha,
                                    'Manifiesto': numero,
                                    'Generador': generador,
                                    'Transportista': transportista,
                                    'Operador': operador,
                                    'Tipo_Residuo': tipoResiduo[i],
                                    'kilos_Residuo': kilosResiduo[i]
                                    }
                     
                     df = pd.concat([df, pd.DataFrame([nueva_fila])], ignore_index=True)
        except IOError:
            print(f"Error al abrir o leer el archivo {ruta_archivo}")     
    

if __name__ == '__main__':
    df.to_excel('examples.xlsx', index=False)

##holus me gusta el pan