//tipo_dispositivos
INSERT INTO `tipo_dispositivos` (`id`, `descripcion`) VALUES (1, 'Computador');
INSERT INTO `tipo_dispositivos` (`id`, `descripcion`) VALUES (2, 'Tablet');

//tipo_cifrados
INSERT INTO `tipo_cifrados` (`id`, `descripcion`) VALUES (1, 'WEB');
INSERT INTO `tipo_cifrados` (`id`, `descripcion`) VALUES (2, 'WPA');

//Conexiones
INSERT INTO `conexiones` (`id`,`tipo_con`, `contraseña`, `nombre`, `usuario`, `tipo_cifrado`) VALUES (1, 1, '123456', 'con_1', 'user1', 1);
INSERT INTO `conexiones` (`id`,`tipo_con`, `contraseña`, `nombre`, `usuario`, `tipo_cifrado`) VALUES (2, 0, '123456', 'con_2', 'user2', 2);

//Dispositivos
INSERT INTO `dispositivos` (`id`, `conectado`, `ip`, `mac`, `conexion`, `tipo_dispositivo`) VALUES (1, 0, '192.168.0.1', 'MCS-VDE43-CSD4', NULL, 1);
INSERT INTO `dispositivos` (`id`, `conectado`, `ip`, `mac`, `conexion`, `tipo_dispositivo`) VALUES (2, 0, '192.168.0.15', '1MCS-VDE43-CSD4', NULL, 2);
