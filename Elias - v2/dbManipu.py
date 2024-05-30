import sqlite3

conn = sqlite3.connect('localDB')
c = conn.cursor()

try:
    c.execute('''DROP TABLE data''')
except sqlite3.OperationalError:
    pass  # La tabla no existe, no es necesario eliminarla

c.execute('''CREATE TABLE data(Tipo_certificado TEXT, Fecha DATE, Manifiesto INTEGER, Generador TEXT, Transportista TEXT, Operador TEXT, Tipo_Residuo VARCHAR, kilos_Residuo INTEGER)''')

def insertDB(tipo_certificado, fecha, numero, generador, transportista, operador, tipoResiduo, kilosResiduo):
    c.execute('''insert into data VALUES(?,?,?,?,?,?,?,?)''',( tipo_certificado, fecha, numero, generador, transportista, operador, tipoResiduo, kilosResiduo))