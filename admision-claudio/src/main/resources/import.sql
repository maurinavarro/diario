/* Script para la generación de valores iniciales */
/* Unidades Penitenciarias */
INSERT INTO `admision_db`.`unidades` (`id`, `cantidad`, `cupo`, `nombre`, `plaza`) VALUES ('1', '480', '500', 'Compejo Penitenciario I (Resistencia)', '20');
INSERT INTO `admision_db`.`unidades` (`id`, `cantidad`, `cupo`, `nombre`, `plaza`) VALUES ('2', '490', '500', 'Complejo Penitenciario II (Saenz Peña)', '10');
INSERT INTO `admision_db`.`unidades` (`id`, `cantidad`, `cupo`, `nombre`, `plaza`) VALUES ('3', '30', '40', 'Unidad Penitenciaria I (Mujeres)', '10');
INSERT INTO `admision_db`.`unidades` (`id`, `cantidad`, `cupo`, `nombre`, `plaza`) VALUES ('4', '60', '75', 'Unidad Penitenciaria II (Gral. San Martin)', '15');
INSERT INTO `admision_db`.`unidades` (`id`, `cantidad`, `cupo`, `nombre`, `plaza`) VALUES ('5', '80', '85', 'Unidad Penitenciaria III (Villa Angela)', '05');
INSERT INTO `admision_db`.`unidades` (`id`, `cantidad`, `cupo`, `nombre`, `plaza`) VALUES ('6', '59', '70', 'Unidad Penitenciaria IV (Charata)', '11');
INSERT INTO `admision_db`.`unidades` (`id`, `cantidad`, `cupo`, `nombre`, `plaza`) VALUES ('7', '40', '45', 'Unidad Penitenciaria V (JJ Castelli)', '05');


/* fuerzas de seguridad */
INSERT INTO `admision_db`.`fuezas` (`id`, `activo`, `nombre`) VALUES ('1', 1, 'Policia del Chaco');
INSERT INTO `admision_db`.`fuezas` (`id`, `activo`, `nombre`) VALUES ('2', 1, 'Policia Federal');
INSERT INTO `admision_db`.`fuezas` (`id`, `activo`, `nombre`) VALUES ('3', 1, 'Gendarmeria');
INSERT INTO `admision_db`.`fuezas` (`id`, `activo`, `nombre`) VALUES ('4', 1, 'Servicio Penitenciaro Federal');
INSERT INTO `admision_db`.`fuezas` (`id`, `activo`, `nombre`) VALUES ('5', 1, 'Servicio Penitenciario Otra Provincia');
INSERT INTO `admision_db`.`fuezas` (`id`, `activo`, `nombre`) VALUES ('6', 1, 'Otros');



/* ROLES */
INSERT INTO `admision_db`.`permisos` (`id`, `nombre`) VALUES ('1', 'ROLE_SUPERUSUARIO');
INSERT INTO `admision_db`.`permisos` (`id`, `nombre`) VALUES ('2', 'ROLE_ADMINISTRADOR');
INSERT INTO `admision_db`.`permisos` (`id`, `nombre`) VALUES ('3', 'ROLE_SOLICTANTE');


-- /* Usuarios - en las pruebas todas las claves son 'usuario' */
INSERT INTO `admision_db`.`usuarios` (`id`, `activo`, `celular`, `clave`, `dni`, `email`, `funcion`, `jerarquia`, `nombre`, `unidad_soliciante`, `id_fuerza`, `id_permiso`) VALUES ('1', '1', '3624', '$2a$10$nmsnELze.Ca7dMnsbfGIuuczJlKMAk9SGCkgDczmosj91zCAMsFoO', '31876543', 'Cmarangoni8@gmail.com', 'Jefe de Unidad', 'Comisario Mayor', 'claudio Marangoni', 'Comisaria Primera Fontana', '1', '1');
INSERT INTO `admision_db`.`usuarios` (`id`, `activo`, `celular`, `clave`, `dni`, `email`, `funcion`, `jerarquia`, `nombre`, `unidad_soliciante`, `id_fuerza`, `id_permiso`) VALUES ('2', '1', '3624', '$2a$10$nmsnELze.Ca7dMnsbfGIuuczJlKMAk9SGCkgDczmosj91zCAMsFoO', '31876543', 'nuevo@gmail.com', 'Jefe de Unidad', 'Comisario Mayor', 'noah Marangoni', 'Comisaria Segunda Fontana', '1', '2');
INSERT INTO `admision_db`.`usuarios` (`id`, `activo`, `celular`, `clave`, `dni`, `email`, `funcion`, `jerarquia`, `nombre`, `unidad_soliciante`, `id_fuerza`, `id_permiso`) VALUES ('3', '1', '3624', '$2a$10$nmsnELze.Ca7dMnsbfGIuuczJlKMAk9SGCkgDczmosj91zCAMsFoO', '31876543', 'gabi@gmail.com', 'Jefe de Unidad', 'Comisario Mayor', 'gabriel Roman', 'Comisaria Primera Resistencia', '1', '1');

