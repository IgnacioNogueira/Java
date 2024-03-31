# Turismo en la Tierra Media

![image](https://github.com/fskcontacto/fskcttm/assets/133590555/786a661a-6f54-4bae-934a-f4b71c7b57b9)

## ¿Cómo ejecutar el programa?

Para ejecutar lo desarollado, debe realizar los siguientes pasos:

1- Dirigirse a __src/turismo/sistema__ <br />
2- Ejecutar el archivo __App.java__

## Formato de archivos de entrada

### Archivo de Atracciones

- Nombre de atracción
- Costo
- Duración
- Cupo
- Tipo de atracción
    - 0 --> Paisaje
    - 1 --> Aventura
    - 2 --> Degustación

#### Ejemplo

```
Minas Tirith
5
2.5
25
0
```

### Archivo de Paquetes

- Tipo de paquete
    - 0 --> ABSOLUTO
    - 1 --> PORCENTUAL
    - 2 --> AXB
- Tipo de atracciones del paquete
    - 0 --> Paisaje
    - 1 --> Aventura
    - 2 --> Degustación
- Nombre de atracciones separados por ";"
- _Campo extra dependiendo tipo de paquete_

#### En caso de paquete "ABSOLUTO"

- Campo extra --> Precio final

#### En caso de paquete "PORCENTUAL"

- Campo extra --> Porcentaje de descuento

#### En caso de paquete "AXB"

- Campo extra --> Atracciones gratuitas separadas por ";"

#### Ejemplo

```
2
0
Minas Tirith;Abismo de Helm
Erebor
```

### Archivo de Usuarios

- Nombre de usuario
- Tipo de atracción preferida
    - 0 --> Paisaje
    - 1 --> Aventura
    - 2 --> Degustación
- Presupuesto
- Tiempo

#### Ejemplo

```
Frodo
1
10
8
```

## Formato de archivos de salida

El formato del archivo de salida (.out) varía dependiendo de los siguientes casos:

### Usuarios aceptaron atracciones

-  Para este caso, se muestra en el archivo de salida el itinerario de cada usuario, concretando las ventas del día.

![image](https://github.com/fskcontacto/fskcttm/assets/105324633/ed09a9af-e54d-48b5-a8ec-398097c3eb8c)

### Usuarios rechazaron todas las atracciones

- Para este caso, el archivo de salida cuenta con una leyenda indicando que no se realizaron ventas en el día debido a que ningún usuario aceptó ninguna sugerencia.

![image](https://github.com/fskcontacto/fskcttm/assets/105324633/b389e7e3-930f-4410-9ce9-3de0ee4fad01)

## Links

- Link a [grabación](https://drive.google.com/file/d/1D1bzJ78oiWx6ao8PSxuBvwOM_Fs7rSVW/view?usp=drive_link)
- Link a [Diagrama UML](https://drive.google.com/file/d/13_O_Swqhdreu9eiEo4ZctsyJnewYErgp/view)
- Link a presentación [PPT](https://docs.google.com/presentation/d/1viy9rU5iSf6FHE3lOPbGHDJVo9vLV29h/edit?usp=sharing&ouid=112941802210794310975&rtpof=true&sd=true)

## Integrantes del equipo

- Alesina, Alan – DNI: 40.913.809
- Botto, Juan – DNI: 42.393.917
- Collazo, Ignacio – DNI: 41.537.099
- Espíndola, Gianluca – DNI: 38.585.140
- Felice, Tomás – DNI: 44.789.809
- Loiotile, Juan - DNI: 42.101.782
- Nogueira, Ignacio – DNI: 41.714.018
