-- CREATE DATABASE code_and_dance;
use code_and_dance;
/*
CREATE TABLE Profesor
(IdProfesor INT PRIMARY KEY,
NombreP VARCHAR(30),
ApellidoP VARCHAR(30),
Salario FLOAT,
EmailP VARCHAR (50) NOT NULL UNIQUE,
EsAdmin BOOLEAN,
Imagen VARCHAR(500)); 

CREATE TABLE Curso
(IdCurso INT PRIMARY KEY,
Tipo VARCHAR (30),
Horario TIME,
Nivel ENUM('principiante', 'medio', 'avanzado'),
Precio FLOAT CHECK (Precio > 0),
Plaza INT,
FInicio DATE,
FFin DATE,
IdProfesor INT NOT NULL,
FOREIGN KEY(IdProfesor) REFERENCES Profesor(IdProfesor) ON DELETE CASCADE ON UPDATE CASCADE);

CREATE TABLE Bailarin
(DniBailarin CHAR(9) PRIMARY KEY,
NombreB VARCHAR(30),
ApellidoB VARCHAR(30),
FechaNacimiento DATE,
Telefono INT,
EmailB VARCHAR(50) NOT NULL UNIQUE);

CREATE TABLE Participa
(IdCurso INT,
DniBailarin CHAR(9),
PRIMARY KEY(IdCurso, DniBailarin),
FOREIGN KEY(IdCurso) REFERENCES Curso(IdCurso) ON DELETE CASCADE ON UPDATE CASCADE,
FOREIGN KEY(DniBailarin) REFERENCES Bailarin(DniBailarin) ON DELETE CASCADE ON UPDATE CASCADE);

INSERT INTO profesor VALUES
(1, 'Karen', 'Meza', 2500.00, 'karen@email.com', TRUE, '/imagenes/Karen.jpg'),
(2, 'Luis', 'Vazquez', 2300.00, 'luis@email.com', FALSE, '/imagenes/Luis.jpg'),
(3, 'Marcos', 'Serrano', 2800.00, 'marcos@email.com', FALSE, '/imagenes/Marcos.jpg'),
(4, 'Unai', 'Azkorra', 2200.00, 'unai@email.com', FALSE, '/imagenes/Unai.jpg');



INSERT INTO bailarin VALUES
('12345678A', 'Leire', 'Sánchez', '2002-03-24', 600123456, 'leire@email.com'),
('23456789B', 'Raquel', 'Gómez', '1999-03-24', 611234567, 'raquel@email.com'),
('34567890C', 'Begoña', 'Díaz', '1994-03-24', 622345678, 'begona@email.com'),
('45678901D', 'Aiora', 'Pérez', '1997-03-24', 633456789, 'aiora@email.com'),
('56789012E', 'Ainara', 'Rodríguez', '2005-03-24', 644567890, 'ainara@email.com'),
('67890123F', 'Aitor', 'Jiménez', '1998-03-24', 655678901, 'aitor@email.com'),
('78901234G', 'Jon', 'Hernández', '2001-03-24', 666789012, 'jon@email.com'),
('89012345H', 'Roberto', 'Ruiz', '1996-03-24', 677890123, 'roberto@email.com'),
('90123456I', 'Amaia', 'Torres', '1999-03-24', 688901234, 'amaia@email.com'),
('01234567J', 'Carmen', 'Vázquez', '2002-03-24', 699012345, 'carmen@email.com');

-- Cursos para cada profesor (1 por nivel)
INSERT INTO Curso VALUES
(1, 'Salsa', '18:00:00', 'principiante', 50.00, 20, '2024-01-10', '2024-03-20', 1),
(2, 'Salsa', '19:30:00', 'medio', 60.00, 15, '2024-01-11', '2024-03-21', 1),
(3, 'Salsa', '21:00:00', 'avanzado', 70.00, 10, '2024-01-12', '2024-03-22', 1),
(4, 'Bachata', '18:00:00', 'principiante', 45.00, 20, '2024-01-10', '2024-03-20', 2),
(5, 'Bachata', '19:30:00', 'medio', 55.00, 15, '2024-01-11', '2024-03-21', 2),
(6, 'Bachata', '21:00:00', 'avanzado', 65.00, 10, '2024-01-12', '2024-03-22', 2),
(7, 'Hip Hop', '18:00:00', 'principiante', 60.00, 20, '2024-01-10', '2024-03-20', 3),
(8, 'Hip Hop', '19:30:00', 'medio', 70.00, 15, '2024-01-11', '2024-03-21', 3),
(9, 'Hip Hop', '21:00:00', 'avanzado', 80.00, 10, '2024-01-12', '2024-03-22', 3),
(10, 'Tango', '18:00:00', 'principiante', 55.00, 20, '2024-01-10', '2024-03-20', 4),
(11, 'Tango', '19:30:00', 'medio', 65.00, 15, '2024-01-11', '2024-03-21', 4),
(12, 'Tango', '21:00:00', 'avanzado', 75.00, 10, '2024-01-12', '2024-03-22', 4);

-- Participaciones (cada bailarín en 3 cursos)
INSERT INTO Participa VALUES
-- Bailarín 1 (3 cursos)
(1, '12345678A'), (4, '12345678A'), (7, '12345678A'),
-- Bailarín 2 (3 cursos)
(2, '23456789B'), (5, '23456789B'), (8, '23456789B'),
-- Bailarín 3 (3 cursos)
(3, '34567890C'), (6, '34567890C'), (9, '34567890C'),
-- Bailarín 4 (3 cursos)
(1, '45678901D'), (5, '45678901D'), (10, '45678901D'),
-- Bailarín 5 (3 cursos)
(2, '56789012E'), (6, '56789012E'), (11, '56789012E'),
-- Bailarín 6 (3 cursos)
(3, '67890123F'), (7, '67890123F'), (12, '67890123F'),
-- Bailarín 7 (3 cursos)
(4, '78901234G'), (8, '78901234G'), (10, '78901234G'),
-- Bailarín 8 (3 cursos)
(5, '89012345H'), (9, '89012345H'), (11, '89012345H'),
-- Bailarín 9 (3 cursos)
(6, '90123456I'), (7, '90123456I'), (12, '90123456I'),
-- Bailarín 10 (3 cursos)
(1, '01234567J'), (8, '01234567J'), (11, '01234567J');
*/

-- ************** PROCEDIMIENTOS Y FUNCIONES **********************

/* 1. Necesitamos un procedimiento al cual llamaremos obtenerDatosCurso que reciba el ID de un curso como parámetro de entrada 
y devuelva tres valores como parámetros de salida que serán el nombre del curso, nivel de curso y precio del curso. */
/*
DELIMITER //

CREATE PROCEDURE obtenerDatosCurso(idC INT, OUT nombreC VARCHAR(30), 
OUT nivelC ENUM('principiante', 'medio', 'avanzado'), OUT precioC FLOAT)
BEGIN
    SELECT Tipo, Nivel, Precio
    INTO nombreC, nivelC, precioC
    FROM Curso
    WHERE IdCurso = idC;
END //
*/

/* 2. Crearemos un procedimiento llamado actualizarSalario que recorra todos los profesores y, si tienen más de 10 bailarines en sus cursos, 
aumente su salario en un 10%.*/
/*
DELIMITER //

CREATE PROCEDURE actualizarSalario()
BEGIN
    DECLARE IdP INT;
    DECLARE cantidadBailarines INT;

    DECLARE C CURSOR FOR
        SELECT p.IdProfesor, COUNT(*) FROM Profesor p 
        JOIN Curso c ON p.IdProfesor = c.IdProfesor JOIN Participa pa 
        ON c.IdCurso = pa.IdCurso GROUP BY p.IdProfesor;

    DECLARE CONTINUE HANDLER FOR NOT FOUND SET cantidadBailarines = -1;
    
    OPEN C;

    REPEAT
        FETCH C INTO IdP, CantidadBailarines;

        IF CantidadBailarines > 10 THEN
            UPDATE Profesor
            SET Salario = Salario * 1.1 
            WHERE IdProfesor = IdP;
        END IF;

    UNTIL CantidadBailarines = -1 END REPEAT;

    CLOSE C;
END //
*/

/* 3. Crearemos un procedimiento llamado TransferirBailarinDeCurso que nos permita mediante el DNI del Bailarin transferirlo de
un curso a otro, verificando que esté inscrito en el curso original.
*/
/*
DELIMITER //

CREATE PROCEDURE TransferirBailarinDeCurso(DniB CHAR(9), IdCursoA INT, IdCursoN INT)
BEGIN
    IF NOT EXISTS (SELECT 1 FROM Participa WHERE DniBailarin = DniB AND IdCurso = IdCursoA) THEN
        SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = 'El bailarín no está inscrito en el curso antiguo';
    ELSE
            DELETE FROM Participa WHERE DniBailarin = DniB AND IdCurso = IdCursoA;
            INSERT INTO Participa(IdCurso, DniBailarin) VALUES (IdCursoN, DniB);
    END IF;
END //
*/

/* 4. Crearemos un procedimiento llamado AumentarPlazasCurso que, dado el ID de un curso y el número de plazas a aumentar, actualice 
el curso añadiendo las plazas especificadas. Si el curso no se encuentra, lanzará un error con el mensaje "Curso no encontrado".
*/
/*
DELIMITER //

CREATE PROCEDURE AumentarPlazasCurso(IdC INT, AumentoPlazas INT)
BEGIN
    DECLARE plazas INT;
    
    SELECT Plaza INTO plazas FROM Curso WHERE IdCurso = IdC;

    IF plazas IS NOT NULL THEN
    
        UPDATE Curso
        SET Plaza = plazas + AumentoPlazas
        WHERE IdCurso = IdC;
        
        SELECT CONCAT('El curso con ID ', IdC, ' ahora tiene ', plazas + AumentoPlazas, ' plazas.');
    ELSE
        SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = 'Curso no encontrado.';
    END IF;
END //
*/

/* 5. Crearemos una función que, dado el ID del curso nos devolverá las plazas disponibles del mismo y en caso
de que no encontremos el curso nos devolverá NULL. 
*/
/*
DELIMITER //
CREATE FUNCTION plazasDisponibles(idCurso INT)
RETURNS INT
    DETERMINISTIC
BEGIN
    DECLARE plazasTotales INT;
    DECLARE plazasOcupadas INT;
    DECLARE plazasDisponibles INT;

    SELECT Plaza INTO plazasTotales
    FROM Curso
    WHERE IdCurso = idC;
    
	IF plazasTotales IS NULL THEN
        RETURN NULL;
    END IF;
    
    SELECT COUNT(*) INTO plazasOcupadas
    FROM Participa
    WHERE IdCurso = idC;
    
    SET plazasDisponibles = plazasTotales - plazasOcupadas;

    RETURN plazasDisponibles;
END //
*/

/* 6. Crearemos una función que, nos devolverá el número de plazas disponibles del curso del cual hemos 
pasado por parámetro el ID. 
*/
/*
DELIMITER //

CREATE FUNCTION totalIngresos(idC INT)
RETURNS FLOAT
	DETERMINISTIC
BEGIN
    DECLARE prec FLOAT;
    DECLARE plazasOcupadas INT;
    DECLARE ingresos FLOAT;

    SELECT Precio INTO prec
    FROM Curso
    WHERE IdCurso = idC;

    SELECT COUNT(*) INTO plazasOcupadas
    FROM Participa
    WHERE IdCurso = idC;

    SET ingresos = prec * plazasOcupadas;

    RETURN ingresos;
END;
*/

/* 7. La función estaInscrito recibe el DNI de un bailarin y el ID de un curso. Devuelve TRUE (1) si el bailarin 
está inscrito en el curso, o FALSE (0) si no lo está.
*/
/*
DELIMITER //
CREATE FUNCTION estaInscrito(dniB CHAR(9), idC INT)
RETURNS BOOLEAN
DETERMINISTIC
BEGIN
    DECLARE resultado BOOLEAN;
    
    SELECT CASE WHEN EXISTS (SELECT 1 FROM Participa WHERE DniBailarin = dni_bailarin AND IdCurso = id_curso) 
               THEN TRUE 
               ELSE FALSE 
           END 
    INTO resultado;
    
    RETURN resultado;
END;  
*/

/* 8. Crearemos una función llamada totalBailarinesCapacesDeInscritos que calcula el porcentaje de bailarines 
inscritos en los cursos de un profesor en relación con la capacidad total de esos cursos. Recibe como parámetro
el id del profesor y devuelve el porcentaje de bailarines respecto al total de plazas disponibles en sus cursos.
*/
/*DELIMITER //

CREATE FUNCTION totalBailarinesCapacesDeInscritos(idP int) 
RETURNS FLOAT
DETERMINISTIC
BEGIN
        DECLARE contB INT DEFAULT 0;
        DECLARE contP INT DEFAULT 0;
        DECLARE plazas INT DEFAULT 0;
        DECLARE result FLOAT DEFAULT 0;
        DECLARE fin BOOL DEFAULT 0;
        DECLARE c CURSOR FOR SELECT Plaza FROM curso WHERE IdProfesor = idP;
		DECLARE CONTINUE HANDLER FOR NOT FOUND SET fin=-1;
        SELECT COUNT(DISTINCT(DniBailarin)) INTO contB FROM participa WHERE IdCurso IN (SELECT IdCurso FROM Curso WHERE IdProfesor=idp);
		OPEN c;
		FETCH c INTO contP;
			WHILE fin=0 DO
				SET plazas=plazas+contP;
				FETCH c INTO contP;
			END WHILE;
         SET result = contB/plazas * 100;
        RETURN result;
	END //
    */