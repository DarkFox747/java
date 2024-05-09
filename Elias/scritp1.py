import os
from bs4 import BeautifulSoup
pwd=os.getcwd()

#importamos el txt
#ruta = pwd + "\\data\\12161663.txt"
#if os.path.exists(ruta):
    # Abre el archivo en modo lectura ('r')
#    with open(ruta, 'r') as archivo:
        # Lee y muestra el contenido del archivo
#        contenido = archivo.read()
#else:
#    print("El archivo no existe en la ruta especificada.")

#FUNCION PARA ENCONTRAR EL TIPO DE CERTIFICADO
# Función para extraer la información de destino del residuo
def extraer_destino_residuo(html_content):
    # Parsea el contenido HTML con BeautifulSoup
    soup = BeautifulSoup(html_content, 'html.parser')
    
    # Encuentra la sección que contiene "Destino del residuo"
    destino_section = soup.find('p', string='Destino del residuo:')
    
    # Verifica si se encontró la sección
    if destino_section:
        # Encuentra la siguiente etiqueta <p class="fuente"> que contiene la información deseada
        info_section = destino_section.find_next('p', class_='fuente')
        
        # Verifica si se encontró la información
        if info_section:
            return info_section.text.strip()  # Devuelve el texto limpio (sin espacios en blanco al inicio y al final)
    
    return "Texto no encontrado"

# Extrae la información de destino del residuo y muestra el resultado
#texto_extraido = extraer_destino_residuo(contenido)
#print(texto_extraido)

#FUNCION PARA EXTRAER EL NUMERO Y LA FECHA DEL ARCHIVO
def extraer_numero_fecha(html_content):
    # Parsea el contenido HTML con BeautifulSoup
    soup = BeautifulSoup(html_content, 'html.parser')
    
    # Encuentra la sección que contiene el número
    numero_section = soup.find('strong', string=lambda text: "N°" in text)
    numero = numero_section.text.split()[1] if numero_section else "Número no encontrado"
    
    # Encuentra la sección que contiene la fecha de viaje
    fecha_section = soup.find('strong', string=lambda text: "Fecha de Viaje:" in text)
    fecha = fecha_section.text.split(":")[1].strip() if fecha_section else "Fecha no encontrada"
    
    return fecha,numero

def extraer_numero(html_content):
    # Parsea el contenido HTML con BeautifulSoup
    soup = BeautifulSoup(html_content, 'html.parser')
    
    # Encuentra la sección que contiene el número
    numero_section = soup.find('strong', string=lambda text: "N°" in text)
    numero = numero_section.text.split()[1] if numero_section else "Número no encontrado"
    
    return numero

def extraer_fecha(html_content):
    # Parsea el contenido HTML con BeautifulSoup
    soup = BeautifulSoup(html_content, 'html.parser')
    
    # Encuentra la sección que contiene la fecha de viaje
    fecha_section = soup.find('strong', string=lambda text: "Fecha de Viaje:" in text)
    fecha = fecha_section.text.split(":")[1].strip() if fecha_section else "Fecha no encontrada"
    
    return fecha
# Extrae el número y la fecha de viaje y muestra el resultado
#numero_extraido, fecha_extraida = extraer_numero_fecha(contenido)
#print("Fecha de Viaje:", fecha_extraida)
#print("Número:", numero_extraido)



# Función para extraer la razón social
def extraer_razon_social(html_content):
    # Parsea el contenido HTML con BeautifulSoup
    soup = BeautifulSoup(html_content, 'html.parser')
    
    # Encuentra la sección que contiene la razón social
    razon_social_section = soup.find('p', class_='fuente', string='Razon Social:')
    razon_social = razon_social_section.find_next('p', class_='fuente').text.strip() if razon_social_section else "Razón social no encontrada"
    
    return razon_social
# Extrae la razón social y muestra el resultado
#razon_social_extraida = extraer_razon_social(contenido)
#print("Razón Social:", razon_social_extraida)



# Función para extraer la razón social de los transportistas
def extraer_razon_social_transportista(html_content):
    # Parsea el contenido HTML con BeautifulSoup
    soup = BeautifulSoup(html_content, 'html.parser')
    
    # Encuentra la sección que contiene la etiqueta "Transportista"
    transportista_section = soup.find('b', string='Transportista')
    
    # Verifica si se encontró la sección del transportista
    if transportista_section:
        # Encuentra la sección que contiene la razón social del transportista
        razon_social_section = transportista_section.find_next('p', class_='fuente', string='Razon Social:')
        razon_social = razon_social_section.find_next('p', class_='fuente').text.strip() if razon_social_section else "Razón social del transportista no encontrada"
    else:
        razon_social = "Sección de transportista no encontrada"    
    return razon_social
# Extrae la razón social del transportista y muestra el resultado
#razon_social_transportista = extraer_razon_social_transportista(contenido)
#print("Razón Social del Transportista:", razon_social_transportista)


# Función para extraer la razón social del destino
def extraer_razon_social_destino(html_content):
    # Parsea el contenido HTML con BeautifulSoup
    soup = BeautifulSoup(html_content, 'html.parser')
    
    # Encuentra la etiqueta <b> que contiene el texto "Destino" como marcador
    destino_b = soup.find('b', string='Destino')
    
    if destino_b:
        # Encuentra la siguiente etiqueta <p class="fuente"> que contiene la razón social del destino
        razon_social_p = destino_b.find_next('p', class_='fuente', string='Razon Social:')
        razon_social = razon_social_p.find_next('p', class_='fuente').text.strip() if razon_social_p else "Razón social del destino no encontrada"
    else:
        razon_social = "Sección de destino no encontrada"
    
    return razon_social
# Extrae la razón social del destino y muestra el resultado
#razon_social_destino = extraer_razon_social_destino(contenido)
#print("Razón Social del destino:", razon_social_destino)

def extraer_categoria_y_cantidad(html_content):
    # Parsea el contenido HTML con BeautifulSoup
# Parsea el contenido HTML con BeautifulSoup
    soup = BeautifulSoup(html_content, 'html.parser')

    verificacion_residuos_operador = soup.find('p', class_='lead', string='Verificacion Residuos Operador')

    if verificacion_residuos_operador:
        # Encuentra todas las secciones que contienen la información después de la verificación "Residuos Operador"
        secciones = verificacion_residuos_operador.find_all_next('div', class_='row')

        # Lista para almacenar los resultados
        resultados = []

        for seccion in secciones:
            # Busca la sección que contiene la etiqueta <b> con el texto "Categoria Desecho Principal:"
            categoria_desecho = seccion.find('p', class_='fuente', string='Categoria Desecho Principal:')
            if categoria_desecho:
                categoria = categoria_desecho.find_next('p', class_='fuente').text.strip().split()[0]
                

                # Busca la cantidad en kilos
                cantidad_kilos = seccion.find('p', class_='fuente', string=lambda text: text and 'Cantidad(Kilos): ' in text)
                cantidad = cantidad_kilos.find_next('p', class_='fuente').text.strip() if cantidad_kilos else "No se encontró la cantidad"

                resultados.append(categoria)
    return resultados
#categorias_y_cantidades_extraidas = extraer_categoria_y_cantidad(contenido)
#print(categorias_y_cantidades_extraidas)


#cantidad de killos: 
def kilos(html_content):
# Parsea el contenido HTML con BeautifulSoup
    soup = BeautifulSoup(html_content, 'html.parser')
    verificacion_residuos_operador = soup.find('p', class_='lead', string='Verificacion Residuos Operador')

    if verificacion_residuos_operador:
        # Encuentra todas las secciones que contienen la información después de la verificación "Residuos Operador"
        secciones = verificacion_residuos_operador.find_all_next('div', class_='row')
        # Lista para almacenar los resultados
        resultados = []

        for seccion in secciones:
            # Busca la sección que contiene la etiqueta <b> con el texto "Categoria Desecho Principal:"
            categoria_desecho = seccion.find( string='Cantidad(Kilos): ')
            if categoria_desecho:
                categoria = categoria_desecho.find_next('p', class_='fuente').text.strip().split()[0]
                

                

                resultados.append(categoria)
    return resultados
#kilos_sacados = kilos(contenido)
#print(kilos_sacados)
