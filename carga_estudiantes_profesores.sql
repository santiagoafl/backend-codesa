
-- =============================
--    Carga de Estudiantes
-- =============================
INSERT INTO ESTUDIANTE (nombre, apellido, fecha_nacimiento, email, telefono, numero_matricula, grado) VALUES
  ('Lucas', 'Torres', '2005-06-12', 'lucas.torres@example.com', '3104567890', 'EST104', '10'),
  ('Mariana', 'González', '2006-08-30', 'mariana.gonzalez@example.com', '3112223344', 'EST105', '11'),
  ('Samuel', 'Ramírez', '2004-04-15', 'samuel.ramirez@example.com', '3123344556', 'EST106', '12'),
  ('Natalia', 'Cruz', '2007-03-21', 'natalia.cruz@example.com', '3100001111', 'EST107', '9'),
  ('Daniel', 'Moreno', '2005-01-02', 'daniel.moreno@example.com', '3110002222', 'EST108', '10'),
  ('Isabela', 'Sánchez', '2006-11-19', 'isabela.sanchez@example.com', '3120003333', 'EST109', '11'),
  ('Mateo', 'Luna', '2003-09-23', 'mateo.luna@example.com', '3130004444', 'EST110', '12'),
  ('Camila', 'Vega', '2004-02-28', 'camila.vega@example.com', '3140005555', 'EST111', '12'),
  ('Andrés', 'Paredes', '2007-07-07', 'andres.paredes@example.com', '3150006666', 'EST112', '9'),
  ('Laura', 'Salas', '2005-10-10', 'laura.salas@example.com', '3160007777', 'EST113', '10'),
  ('Sebastián', 'Ochoa', '2006-01-15', 'sebastian.ochoa@example.com', '3170008888', 'EST114', '11'),
  ('Valentina', 'Ríos', '2004-05-05', 'valentina.rios@example.com', '3180009999', 'EST115', '12'),
  ('Tomás', 'Silva', '2007-12-12', 'tomas.silva@example.com', '3190001010', 'EST116', '9'),
  ('Luciana', 'Mejía', '2005-03-03', 'luciana.mejia@example.com', '3200002020', 'EST117', '10'),
  ('Juan', 'Herrera', '2003-08-08', 'juan.herrera@example.com', '3210003030', 'EST118', '12');

-- =============================
--    Carga de Profesores
-- =============================
INSERT INTO PROFESOR (nombre, apellido, fecha_nacimiento, email, telefono, fecha_contratacion, especialidad) VALUES
  ('Valeria', 'Jiménez', '1985-11-20', 'valeria.jimenez@example.com', '3119876543', '2015-03-15', 'Matemáticas'),
  ('Carlos', 'López', '1978-02-10', 'carlos.lopez@example.com', '3109988776', '2010-08-01', 'Física'),
  ('Ana', 'Martínez', '1990-07-25', 'ana.martinez@example.com', '3134455667', '2018-01-10', 'Historia'),
  ('Diego', 'Ruiz', '1980-04-18', 'diego.ruiz@example.com', '3145566778', '2011-09-25', 'Química'),
  ('Sofía', 'Delgado', '1983-06-30', 'sofia.delgado@example.com', '3156677889', '2017-02-20', 'Biología');
