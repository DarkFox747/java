import os
from scritp1 import*
import pandas as pd
import sqlite3
from dbManipu import*

columnas = ['Tipo_certificado', 'Fecha', 'Manifiesto', 'Generador', 'Transportista', 'Operador', 'Tipo_Residuo', 'kilos_Residuo']
#df = pd.DataFrame(columns=columnas)
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
                     insertDB( tipo_certificado, fecha, numero, generador, transportista, operador, tipoResiduo[i], kilosResiduo[i])
                     
                     #df = pd.concat([df, pd.DataFrame([nueva_fila])], ignore_index=True)
        except IOError:
            print(f"Error al abrir o leer el archivo {ruta_archivo}")     
    
conn.commit()


#c.execute('''SELECT * FROM data''')
sql = pd.read_sql('''SELECT * FROM data''', conn)
df =pd.DataFrame(sql, columns=columnas)

#print(df)
#results = c.fetchall()
#print(results)
conn.close()
#print(df)
nombre_archivo = 'examples.xlsx'
if os.path.exists(nombre_archivo):
    os.remove(nombre_archivo)

# Guardar el DataFrame en un archivo Excel
if __name__ == '__main__':
    df.to_excel('examples.xlsx', index=False)

