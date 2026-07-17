package pe.com.autorenta.logistica.presentation;

import pe.com.autorenta.logistica.application.GestorAlquiler;
import pe.com.autorenta.logistica.infrastructure.structure.GestorPersistencia;

public class GUI extends javax.swing.JFrame {

    private GestorAlquiler gestor = GestorPersistencia.cargarDatos();

    private void aplicarDisenoModerno() {
        // Colores de los Paneles Principales
        jPanel3.setBackground(new java.awt.Color(15, 23, 42)); // Menú lateral oscuro
        jPanel2.setBackground(new java.awt.Color(255, 255, 255)); // Cabecera blanca

        // Barra de estado 
        jPanel5.setBackground(new java.awt.Color(15, 23, 42));
        lblEstadoSistema.setForeground(java.awt.Color.WHITE);
        lblEstadoSistema.setFont(new java.awt.Font("Segoe UI", 0, 14)); // Letra más suave y limpia

        // Textos de la cabecera
        lblTituloLogo.setFont(new java.awt.Font("Segoe UI", 1, 22));
        lblTituloLogo.setForeground(new java.awt.Color(15, 23, 42));
        lblUsuarioActual.setFont(new java.awt.Font("Segoe UI", 1, 14));

        // Reloj de la cabecera
        javax.swing.Timer timer = new javax.swing.Timer(1000, new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent e) {
                java.time.LocalDateTime ahora = java.time.LocalDateTime.now();
                java.time.format.DateTimeFormatter formato = java.time.format.DateTimeFormatter.ofPattern("EEEE d 'de' MMMM, hh:mm:ss a", new java.util.Locale("es", "PE"));
                lblUsuarioActual.setText("Bienvenido | " + ahora.format(formato));
            }
        });
        timer.start();

        // botones del menú lateral modernos 
        java.awt.Color colorNormal = new java.awt.Color(15, 23, 42);
        java.awt.Color colorHover = new java.awt.Color(56, 189, 248);
        java.awt.Color colorClick = new java.awt.Color(2, 132, 199);

        javax.swing.JButton[] menuBotones = {btnInicio, btnVentanilla, btnCatalogo, btnHistorial, btnArbol, btnSalir};
        for (javax.swing.JButton btn : menuBotones) {
            btn.setBackground(colorNormal);
            btn.setForeground(java.awt.Color.WHITE);
            btn.setFocusPainted(false);
            btn.setFont(new java.awt.Font("Segoe UI", 1, 16)); // Letra un poco más grande
            btn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

            // Alinear a la izquierda y darles un padding 
            btn.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
            btn.setBorder(javax.swing.BorderFactory.createEmptyBorder(10, 25, 10, 10));

            btn.addMouseListener(new java.awt.event.MouseAdapter() {
                public void mouseEntered(java.awt.event.MouseEvent evt) {
                    btn.setBackground(colorHover);
                }

                public void mouseExited(java.awt.event.MouseEvent evt) {
                    btn.setBackground(colorNormal);
                }

                public void mousePressed(java.awt.event.MouseEvent evt) {
                    btn.setBackground(colorClick);
                }

                public void mouseReleased(java.awt.event.MouseEvent evt) {
                    btn.setBackground(colorHover);
                }
            });
        }

        java.awt.Font fuenteNumeros = new java.awt.Font("Segoe UI", 1, 48);
        java.awt.Color colorNumeros = new java.awt.Color(56, 189, 248);

        lblTotalFlota.setFont(fuenteNumeros);
        lblTotalFlota.setForeground(colorNumeros);
        lblRentados.setFont(fuenteNumeros);
        lblRentados.setForeground(colorNumeros);
        lblEnEspera.setFont(fuenteNumeros);
        lblEnEspera.setForeground(colorNumeros);

        // Suaviza los subtítulos de las tarjetas 
        java.awt.Color colorSubtitulos = new java.awt.Color(100, 100, 100);
        jLabel5.setForeground(colorSubtitulos);
        jLabel6.setForeground(colorSubtitulos);
        jLabel7.setForeground(colorSubtitulos);

        // Título del resumen principal
        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 28));
        jLabel4.setForeground(new java.awt.Color(51, 51, 51));

        // Estilos de tablas y tarjetas 
        javax.swing.table.DefaultTableCellRenderer centrado = new javax.swing.table.DefaultTableCellRenderer();
        centrado.setHorizontalAlignment(javax.swing.JLabel.CENTER);

        for (int i = 0; i < tblCatalogo.getColumnCount(); i++) {
            tblCatalogo.getColumnModel().getColumn(i).setCellRenderer(centrado);
        }
        if (tblCatalogo.getColumnModel().getColumnCount() > 0) {
            tblCatalogo.getColumnModel().getColumn(0).setPreferredWidth(90);
            tblCatalogo.getColumnModel().getColumn(1).setPreferredWidth(120);
            tblCatalogo.getColumnModel().getColumn(2).setPreferredWidth(150);
            tblCatalogo.getColumnModel().getColumn(3).setPreferredWidth(90);
            tblCatalogo.getColumnModel().getColumn(4).setPreferredWidth(450);
        }

        for (int i = 0; i < tblCola.getColumnCount(); i++) {
            tblCola.getColumnModel().getColumn(i).setCellRenderer(centrado);
        }
        for (int i = 0; i < tblHistorial.getColumnCount(); i++) {
            tblHistorial.getColumnModel().getColumn(i).setCellRenderer(centrado);
        }

        javax.swing.JPanel[] fondos = {pnlInicio, pnlVentanilla, pnlCatalogo, pnlHistorial, pnlArbol, jPanel4, jPanel6, jPanel7, jPanel8, jPanel9};
        for (javax.swing.JPanel pnl : fondos) {
            // Cambiamos a un gris plata súper elegante en lugar de casi blanco
            pnl.setBackground(new java.awt.Color(233, 239, 245));
        }

        pnlCardFlota.setBackground(new java.awt.Color(255, 255, 255));
        pnlCardRentados.setBackground(new java.awt.Color(255, 255, 255));
        pnlCardEspera.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.border.Border bordeTarjetas = javax.swing.BorderFactory.createCompoundBorder(
                javax.swing.BorderFactory.createLineBorder(new java.awt.Color(226, 232, 240), 1, true),
                javax.swing.BorderFactory.createEmptyBorder(10, 10, 10, 10)
        );

        pnlCardFlota.setBorder(bordeTarjetas);
        pnlCardRentados.setBorder(bordeTarjetas);
        pnlCardEspera.setBorder(bordeTarjetas);

        tblCatalogo.setRowHeight(40);
        tblCola.setRowHeight(40);
        tblHistorial.setRowHeight(40);

        tblCatalogo.setSelectionBackground(new java.awt.Color(56, 189, 248));
        tblCatalogo.setSelectionForeground(java.awt.Color.WHITE);
        tblCola.setSelectionBackground(new java.awt.Color(56, 189, 248));
        tblCola.setSelectionForeground(java.awt.Color.WHITE);

        java.awt.Font fuenteTabla = new java.awt.Font("Segoe UI", 0, 14);
        tblCatalogo.setFont(fuenteTabla);
        tblCola.setFont(fuenteTabla);
        tblHistorial.setFont(fuenteTabla);

        java.awt.Font fuenteCabecera = new java.awt.Font("Segoe UI", 1, 14);
        java.awt.Color fondoCabecera = new java.awt.Color(255, 255, 255);
        tblCatalogo.getTableHeader().setFont(fuenteCabecera);
        tblCatalogo.getTableHeader().setBackground(fondoCabecera);
        tblCola.getTableHeader().setFont(fuenteCabecera);
        tblCola.getTableHeader().setBackground(fondoCabecera);
        tblHistorial.getTableHeader().setFont(fuenteCabecera);
        tblHistorial.getTableHeader().setBackground(fondoCabecera);

        tblProximos.setFont(fuenteTabla);
        tblProximos.setRowHeight(35);
        tblProximos.getTableHeader().setFont(fuenteCabecera);
        tblProximos.getTableHeader().setBackground(fondoCabecera);

        ((javax.swing.table.DefaultTableCellRenderer) tblProximos.getTableHeader().getDefaultRenderer()).setHorizontalAlignment(javax.swing.JLabel.CENTER);

        for (int i = 0; i < tblProximos.getColumnCount(); i++) {
            tblProximos.getColumnModel().getColumn(i).setCellRenderer(centrado);
        }

        jPanel10.setBackground(new java.awt.Color(255, 255, 255));
        jScrollPane3.getViewport().setBackground(new java.awt.Color(255, 255, 255));
        jScrollPane3.setBorder(javax.swing.BorderFactory.createEmptyBorder());

        tblProximos.setShowGrid(false);
        tblProximos.setShowHorizontalLines(true);
        tblProximos.setGridColor(new java.awt.Color(235, 235, 235));
        tblProximos.setIntercellSpacing(new java.awt.Dimension(0, 0));

        txtDni.addKeyListener(new java.awt.event.KeyAdapter() {
            @Override
            public void keyTyped(java.awt.event.KeyEvent evt) {
                char c = evt.getKeyChar();
                if (!Character.isDigit(c) || txtDni.getText().length() >= 8) {
                    evt.consume();
                }
            }
        });

        txtPrecio.addKeyListener(new java.awt.event.KeyAdapter() {
            @Override
            public void keyTyped(java.awt.event.KeyEvent evt) {
                char c = evt.getKeyChar();
                String textoActual = txtPrecio.getText();
                if (c == '.') {
                    if (textoActual.contains(".") || textoActual.isEmpty()) {
                        evt.consume();
                    }
                } else if (!Character.isDigit(c)) {
                    evt.consume();
                }
            }
        });

        javax.swing.JButton[] botonesAccion = {btnAgregarCola, btnLlamarTurno, btnRentar, btnOrdenarPrecio, btnExportarPDF, btnDeshacerUltimo, btnRegistrarVehiculo, btnBuscarVehiculo};

        for (javax.swing.JButton btn : botonesAccion) {
            btn.setFont(new java.awt.Font("Segoe UI", 1, 14)); // Letra moderna
            btn.setForeground(java.awt.Color.WHITE); // Texto blanco
            btn.setFocusPainted(false); // Quita el recuadro punteado feo
            btn.setBorderPainted(false); // QUITA EL BORDE 3D GIGANTE
            btn.setOpaque(true); // Permite ver el color de fondo
            btn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR)); // Manito al pasar el mouse
        }

        // Colores específicos para darle jerarquía a los botones
        // Ventanilla
        btnAgregarCola.setBackground(new java.awt.Color(56, 189, 248)); // Azul corporativo
        btnLlamarTurno.setBackground(new java.awt.Color(16, 185, 129)); // Verde (Atender)

        // Vehículos
        btnRentar.setBackground(new java.awt.Color(56, 189, 248)); // Azul corporativo
        btnOrdenarPrecio.setBackground(new java.awt.Color(100, 116, 139)); // Gris pizarra

        // Historial
        btnExportarPDF.setBackground(new java.awt.Color(220, 38, 38)); // Rojo (PDF)
        btnDeshacerUltimo.setBackground(new java.awt.Color(71, 85, 105)); // Gris oscuro (Advertencia)

        // Gestión
        btnRegistrarVehiculo.setBackground(new java.awt.Color(56, 189, 248)); // Azul corporativo
        btnBuscarVehiculo.setBackground(new java.awt.Color(71, 85, 105)); // Gris oscuro

        javax.swing.JScrollPane[] scrollsTablas = {jScrollPane4, jScrollPane1, jScrollPane2}; // Cola, Catalogo, Historial
        javax.swing.JTable[] tablas = {tblCola, tblCatalogo, tblHistorial};

        for (int i = 0; i < scrollsTablas.length; i++) {
            scrollsTablas[i].getViewport().setBackground(new java.awt.Color(255, 255, 255));
            scrollsTablas[i].setBorder(javax.swing.BorderFactory.createEmptyBorder());
            tablas[i].setShowGrid(false);
            tablas[i].setShowHorizontalLines(true);
            tablas[i].setGridColor(new java.awt.Color(235, 235, 235));
            tablas[i].setIntercellSpacing(new java.awt.Dimension(0, 0));
        }

        // Filtro de Marcas
        cbxFiltroMarca.setFont(new java.awt.Font("Segoe UI", 0, 14));
        cbxFiltroMarca.setBackground(new java.awt.Color(255, 255, 255));

        // Resultado Búsqueda
        lblResultadoBusqueda.setFont(new java.awt.Font("Segoe UI", 1, 16));
        lblResultadoBusqueda.setForeground(new java.awt.Color(15, 23, 42));

        // Estilo para el botón Eliminar (Rojo oscuro de advertencia)
        btnEliminarVehiculo.setBackground(new java.awt.Color(220, 38, 38));
        btnEliminarVehiculo.setForeground(java.awt.Color.WHITE);
        btnEliminarVehiculo.setFont(new java.awt.Font("Segoe UI", 1, 14));
        btnEliminarVehiculo.setFocusPainted(false);
        btnEliminarVehiculo.setBorderPainted(false);
        btnEliminarVehiculo.setOpaque(true);
        btnEliminarVehiculo.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        // Efecto Hover para el botón Eliminar
        btnEliminarVehiculo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnEliminarVehiculo.setBackground(new java.awt.Color(185, 28, 28));
            }

            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnEliminarVehiculo.setBackground(new java.awt.Color(220, 38, 38));
            }
        });

    }

    public GUI() {
        initComponents();
        aplicarDisenoModerno();

        this.setSize(1695, 850);

        this.setLocationRelativeTo(null);
        this.addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosing(java.awt.event.WindowEvent windowEvent) {
                GestorPersistencia.guardarDatos(gestor);
            }
        });
        pnlContenedorVistas.removeAll();
        pnlContenedorVistas.add(pnlInicio);
        pnlContenedorVistas.repaint();
        pnlContenedorVistas.revalidate();

        actualizarTablaCatalogo("Todas", false);
        actualizarTablaCola();
        actualizarTablaHistorial();
        actualizarDashboard();
    }

    private void actualizarDashboard() {
        int totalFlota = 0;
        int rentados = 0;
        int enEspera = 0;

        try {
            var lista = gestor.obtenerCatalogoOrdenadoPorMarca();
            if (lista != null) {
                var actual = lista.getCabeza();
                while (actual != null) {
                    pe.com.autorenta.logistica.domain.Vehiculo v = actual.getVehiculo();
                    // SOLO CUENTA LOS VEHÍCULOS ACTIVOS
                    if (v.isEstadoLogico()) {
                        totalFlota++;
                        if (v.getClienteRentado() != null) {
                            rentados++;
                        }
                    }
                    actual = actual.getSiguiente();
                }
            }

            if (gestor.getColaEspera() != null) {
                var actualCola = gestor.getColaEspera().getFrente();
                while (actualCola != null) {
                    enEspera++;
                    actualCola = actualCola.getSiguiente();
                }
            }

            // Actualiza la mini-tabla de próximos clientes 
            javax.swing.table.DefaultTableModel modeloProximos = (javax.swing.table.DefaultTableModel) tblProximos.getModel();
            modeloProximos.setRowCount(0);

            if (gestor != null && gestor.getColaEspera() != null) {
                var nodoActualCola = gestor.getColaEspera().getFrente();
                int turnoLocal = 1;
                while (nodoActualCola != null && turnoLocal <= 5) {
                    pe.com.autorenta.logistica.domain.Cliente c = nodoActualCola.getCliente();
                    modeloProximos.addRow(new Object[]{"#" + turnoLocal, c.getNombre()});
                    nodoActualCola = nodoActualCola.getSiguiente();
                    turnoLocal++;
                }
            }

        } catch (Exception e) {
        }

        lblTotalFlota.setText(String.valueOf(totalFlota));
        lblRentados.setText(String.valueOf(rentados));
        lblEnEspera.setText(String.valueOf(enEspera));
    }

    private void actualizarTablaCatalogo(String marcaFiltro, boolean ordenarPrecio) {
        javax.swing.table.DefaultTableModel modelo = (javax.swing.table.DefaultTableModel) tblCatalogo.getModel();
        modelo.setRowCount(0);

        try {
            var lista = gestor.obtenerCatalogoOrdenadoPorMarca();
            if (lista == null) {
                return;
            }

            java.util.ArrayList<pe.com.autorenta.logistica.domain.Vehiculo> temp = new java.util.ArrayList<>();
            var actual = lista.getCabeza();

            while (actual != null) {
                pe.com.autorenta.logistica.domain.Vehiculo v = actual.getVehiculo();

                // SOLO AGREGA A LA TABLA LOS VEHÍCULOS ACTIVOS
                if (v.isEstadoLogico()) {
                    if (marcaFiltro.equals("Todas") || v.getMarca().equalsIgnoreCase(marcaFiltro)) {
                        temp.add(v);
                    }
                }
                actual = actual.getSiguiente();
            }

            if (ordenarPrecio) {
                temp.sort((v1, v2) -> Double.compare(v1.getPrecio(), v2.getPrecio()));
            }

            for (pe.com.autorenta.logistica.domain.Vehiculo v : temp) {
                String estado = (v.getClienteRentado() == null) ? "DISPONIBLE" : "RENTADO A: " + v.getClienteRentado().getNombre();
                modelo.addRow(new Object[]{v.getPlaca(), v.getMarca(), v.getModelo(), "S/ " + v.getPrecio(), estado});
            }
        } catch (Exception e) {
        }
    }

    private void actualizarTablaCola() {
        javax.swing.table.DefaultTableModel modelo = (javax.swing.table.DefaultTableModel) tblCola.getModel();
        modelo.setRowCount(0);

        try {
            if (gestor == null || gestor.getColaEspera() == null) {
                return;
            }

            var nodoActual = gestor.getColaEspera().getFrente();
            int turno = 1;

            while (nodoActual != null) {
                pe.com.autorenta.logistica.domain.Cliente c = nodoActual.getCliente();
                modelo.addRow(new Object[]{turno, c.getDni(), c.getNombre()});
                nodoActual = nodoActual.getSiguiente();
                turno++;
            }
        } catch (Exception e) {
        }

        actualizarDashboard();
    }

    private void actualizarTablaHistorial() {
        javax.swing.table.DefaultTableModel modelo = (javax.swing.table.DefaultTableModel) tblHistorial.getModel();
        modelo.setRowCount(0);

        try {
            if (gestor == null || gestor.getPilaHistorial() == null) {
                return;
            }

            var actual = gestor.getPilaHistorial().getCima();
            while (actual != null) {
                pe.com.autorenta.logistica.domain.Vehiculo v = actual.getVehiculo();

                // 1. Separamos los datos en variables limpias
                String tipo = "ALQUILER";
                String vehiculo = v.getMarca() + " " + v.getModelo();
                String placa = v.getPlaca();
                String cliente = (v.getClienteRentado() != null) ? v.getClienteRentado().getNombre() : "Devuelto";

                // 2. Agregamos la fila enviando los 4 datos en sus respectivas columnas
                modelo.addRow(new Object[]{tipo, vehiculo, placa, cliente});

                actual = actual.getSiguiente();
            }
        } catch (Exception e) {
        }

        actualizarDashboard();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        lblTituloLogo = new javax.swing.JLabel();
        lblUsuarioActual = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        btnInicio = new javax.swing.JButton();
        btnVentanilla = new javax.swing.JButton();
        btnCatalogo = new javax.swing.JButton();
        btnHistorial = new javax.swing.JButton();
        btnArbol = new javax.swing.JButton();
        btnSalir = new javax.swing.JButton();
        pnlContenedorVistas = new javax.swing.JPanel();
        pnlVentanilla = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        lblVentanilla = new javax.swing.JLabel();
        jPanel11 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        txtNombres = new java.awt.TextField();
        jLabel11 = new javax.swing.JLabel();
        txtApellidos = new java.awt.TextField();
        jLabel9 = new javax.swing.JLabel();
        txtDni = new java.awt.TextField();
        btnAgregarCola = new javax.swing.JButton();
        jPanel12 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        tblCola = new javax.swing.JTable();
        btnLlamarTurno = new javax.swing.JButton();
        pnlCatalogo = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        jPanel13 = new javax.swing.JPanel();
        lblClienteActual = new javax.swing.JLabel();
        jPanel14 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblCatalogo = new javax.swing.JTable();
        btnRentar = new javax.swing.JButton();
        cbxFiltroMarca = new javax.swing.JComboBox<>();
        btnOrdenarPrecio = new javax.swing.JButton();
        pnlHistorial = new javax.swing.JPanel();
        jPanel8 = new javax.swing.JPanel();
        jLabel16 = new javax.swing.JLabel();
        jPanel15 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblHistorial = new javax.swing.JTable();
        btnDeshacerUltimo = new javax.swing.JButton();
        btnExportarPDF = new javax.swing.JButton();
        pnlArbol = new javax.swing.JPanel();
        jPanel9 = new javax.swing.JPanel();
        jLabel18 = new javax.swing.JLabel();
        jPanel16 = new javax.swing.JPanel();
        txtModelo = new java.awt.TextField();
        jLabel22 = new javax.swing.JLabel();
        txtPlaca = new java.awt.TextField();
        jLabel21 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        txtMarca = new java.awt.TextField();
        jLabel20 = new javax.swing.JLabel();
        txtPrecio = new java.awt.TextField();
        btnRegistrarVehiculo = new javax.swing.JButton();
        jPanel17 = new javax.swing.JPanel();
        jLabel25 = new javax.swing.JLabel();
        txtBuscarPlaca = new java.awt.TextField();
        btnBuscarVehiculo = new javax.swing.JButton();
        jPanel18 = new javax.swing.JPanel();
        lblResultadoBusqueda = new javax.swing.JLabel();
        btnEliminarVehiculo = new javax.swing.JButton();
        pnlInicio = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        pnlCardEspera = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        lblEnEspera = new javax.swing.JLabel();
        pnlCardFlota = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        lblTotalFlota = new javax.swing.JLabel();
        pnlCardRentados = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        lblRentados = new javax.swing.JLabel();
        jPanel10 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblProximos = new javax.swing.JTable();
        jPanel5 = new javax.swing.JPanel();
        lblEstadoSistema = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setFocusCycleRoot(true);

        lblTituloLogo.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblTituloLogo.setText(" PrimeDrive Rent System-Sistema de Gestión de Alquiler de Vehículos");

        lblUsuarioActual.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(lblTituloLogo, javax.swing.GroupLayout.PREFERRED_SIZE, 740, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 399, Short.MAX_VALUE)
                .addComponent(lblUsuarioActual, javax.swing.GroupLayout.PREFERRED_SIZE, 399, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(95, 95, 95))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(8, 8, 8)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(lblTituloLogo)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(lblUsuarioActual, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(1, -1, 1660, 50));

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnInicio.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btnInicio.setText(" Inicio ");
        btnInicio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInicioActionPerformed(evt);
            }
        });
        jPanel3.add(btnInicio, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 40, 180, -1));

        btnVentanilla.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btnVentanilla.setText("Ventanilla");
        btnVentanilla.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVentanillaActionPerformed(evt);
            }
        });
        jPanel3.add(btnVentanilla, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 140, 180, -1));

        btnCatalogo.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btnCatalogo.setText(" Vehículos");
        btnCatalogo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCatalogoActionPerformed(evt);
            }
        });
        jPanel3.add(btnCatalogo, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 260, 180, -1));

        btnHistorial.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btnHistorial.setText("Historial");
        btnHistorial.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHistorialActionPerformed(evt);
            }
        });
        jPanel3.add(btnHistorial, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 370, 180, -1));

        btnArbol.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btnArbol.setText(" Gestion");
        btnArbol.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnArbolActionPerformed(evt);
            }
        });
        jPanel3.add(btnArbol, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 480, 180, -1));

        btnSalir.setText(" Salir");
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });
        jPanel3.add(btnSalir, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 570, 110, -1));

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(14, 67, 220, 630));

        pnlContenedorVistas.setBackground(new java.awt.Color(204, 255, 204));
        pnlContenedorVistas.setLayout(new java.awt.CardLayout());

        pnlVentanilla.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel6.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel6.setMinimumSize(new java.awt.Dimension(1420, 630));
        jPanel6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblVentanilla.setFont(new java.awt.Font("Segoe UI Black", 0, 24)); // NOI18N
        lblVentanilla.setText("Ventanilla actual: LIBRE");
        jPanel6.add(lblVentanilla, new org.netbeans.lib.awtextra.AbsoluteConstraints(579, 848, 336, -1));

        jPanel11.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "REGISTRAR NUEVO CLIENTE", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI Black", 0, 24))); // NOI18N

        jLabel10.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel10.setText("NOMBRES:");

        txtNombres.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNombresActionPerformed(evt);
            }
        });

        jLabel11.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel11.setText("APELLIDOS:");

        jLabel9.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel9.setText("DNI:");

        btnAgregarCola.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        btnAgregarCola.setText("AGREGAR A COLA");
        btnAgregarCola.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarColaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel11Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txtNombres, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtApellidos, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel11Layout.createSequentialGroup()
                        .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel10, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel11, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel9, javax.swing.GroupLayout.Alignment.LEADING))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGap(74, 74, 74))
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(txtDni, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addGap(82, 82, 82)
                        .addComponent(btnAgregarCola, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(118, Short.MAX_VALUE))
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(jLabel10)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtNombres, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel11)
                .addGap(8, 8, 8)
                .addComponent(txtApellidos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtDni, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(68, 68, 68)
                .addComponent(btnAgregarCola)
                .addContainerGap(154, Short.MAX_VALUE))
        );

        jPanel6.add(jPanel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 50, 480, 530));

        jPanel12.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "CLIENTES EN ESPERA", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI Black", 0, 24))); // NOI18N

        tblCola.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "TURNO", "DNI", "Nombres y Apellidos"
            }
        ));
        jScrollPane4.setViewportView(tblCola);
        if (tblCola.getColumnModel().getColumnCount() > 0) {
            tblCola.getColumnModel().getColumn(0).setPreferredWidth(50);
            tblCola.getColumnModel().getColumn(1).setPreferredWidth(100);
            tblCola.getColumnModel().getColumn(2).setResizable(false);
            tblCola.getColumnModel().getColumn(2).setPreferredWidth(250);
        }

        btnLlamarTurno.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btnLlamarTurno.setText("ATENDER A CLIENTE");
        btnLlamarTurno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLlamarTurnoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel12Layout.createSequentialGroup()
                        .addGap(119, 119, 119)
                        .addComponent(btnLlamarTurno, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel12Layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 619, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(29, Short.MAX_VALUE))
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 320, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(45, 45, 45)
                .addComponent(btnLlamarTurno, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(80, Short.MAX_VALUE))
        );

        jPanel6.add(jPanel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 50, 680, 530));

        pnlVentanilla.add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(11, 0, 1260, 630));

        pnlContenedorVistas.add(pnlVentanilla, "card3");

        pnlCatalogo.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel7.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel7.setMinimumSize(new java.awt.Dimension(1571, 807));
        jPanel7.setPreferredSize(new java.awt.Dimension(1420, 630));
        jPanel7.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel13.setFont(new java.awt.Font("Segoe UI Black", 0, 36)); // NOI18N
        jLabel13.setText("CATALOGO DE VEHICULOS");
        jPanel7.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 20, -1, -1));

        jPanel13.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "ATENDIENDO A", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI Black", 0, 18))); // NOI18N

        lblClienteActual.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lblClienteActual.setText("--- Ninguno ---");

        javax.swing.GroupLayout jPanel13Layout = new javax.swing.GroupLayout(jPanel13);
        jPanel13.setLayout(jPanel13Layout);
        jPanel13Layout.setHorizontalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(lblClienteActual)
                .addContainerGap(652, Short.MAX_VALUE))
        );
        jPanel13Layout.setVerticalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(lblClienteActual)
                .addContainerGap(38, Short.MAX_VALUE))
        );

        jPanel7.add(jPanel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 90, 810, 120));

        jPanel14.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "CATALOGO ", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI Black", 0, 18))); // NOI18N

        tblCatalogo.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "PLACA", "MARCA", "MODELO", "PRECIO", "ESTADO"
            }
        ));
        jScrollPane1.setViewportView(tblCatalogo);

        btnRentar.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        btnRentar.setText("RENTAR AUTO");
        btnRentar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRentarActionPerformed(evt);
            }
        });

        cbxFiltroMarca.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        cbxFiltroMarca.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Todas", "Toyota", "Hyundai", "Kia", "Audi", "Chevrolet", "Susuki" }));
        cbxFiltroMarca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxFiltroMarcaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel14Layout = new javax.swing.GroupLayout(jPanel14);
        jPanel14.setLayout(jPanel14Layout);
        jPanel14Layout.setHorizontalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addContainerGap(18, Short.MAX_VALUE)
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnRentar, javax.swing.GroupLayout.PREFERRED_SIZE, 343, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1114, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(18, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel14Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(cbxFiltroMarca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(79, 79, 79))
        );
        jPanel14Layout.setVerticalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addComponent(cbxFiltroMarca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 24, Short.MAX_VALUE)
                .addComponent(btnRentar)
                .addGap(18, 18, 18))
        );

        jPanel7.add(jPanel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 230, 1160, 360));

        btnOrdenarPrecio.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        btnOrdenarPrecio.setText("ORDENAR POR PRECIO");
        btnOrdenarPrecio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOrdenarPrecioActionPerformed(evt);
            }
        });
        jPanel7.add(btnOrdenarPrecio, new org.netbeans.lib.awtextra.AbsoluteConstraints(900, 130, -1, 50));

        pnlCatalogo.add(jPanel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 1260, 630));

        pnlContenedorVistas.add(pnlCatalogo, "card4");

        pnlHistorial.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel8.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel8.setMinimumSize(new java.awt.Dimension(1571, 807));
        jPanel8.setPreferredSize(new java.awt.Dimension(1420, 630));
        jPanel8.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel16.setFont(new java.awt.Font("Segoe UI Black", 0, 36)); // NOI18N
        jLabel16.setText("HISTORIAL DE VEHICULOS ALQUILADOS");
        jPanel8.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 30, -1, -1));

        jPanel15.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "ULTIMAS ACCIONES REGISTRADAS", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI Black", 0, 18))); // NOI18N

        tblHistorial.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "TIPO", "VEHICULO", "PLACA", "CLIENTE"
            }
        ));
        jScrollPane2.setViewportView(tblHistorial);

        btnDeshacerUltimo.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btnDeshacerUltimo.setText("Deshacer Último Alquiler");
        btnDeshacerUltimo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeshacerUltimoActionPerformed(evt);
            }
        });

        btnExportarPDF.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btnExportarPDF.setText("Exportar a PDF");
        btnExportarPDF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExportarPDFActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel15Layout = new javax.swing.GroupLayout(jPanel15);
        jPanel15.setLayout(jPanel15Layout);
        jPanel15Layout.setHorizontalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel15Layout.createSequentialGroup()
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel15Layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addComponent(btnExportarPDF, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnDeshacerUltimo))
                    .addGroup(jPanel15Layout.createSequentialGroup()
                        .addContainerGap(22, Short.MAX_VALUE)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 1140, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(28, Short.MAX_VALUE))
        );
        jPanel15Layout.setVerticalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel15Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 357, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnDeshacerUltimo, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnExportarPDF, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(28, 28, 28))
        );

        jPanel8.add(jPanel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 110, 1200, 490));

        pnlHistorial.add(jPanel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(11, 0, 1260, 630));

        pnlContenedorVistas.add(pnlHistorial, "card5");

        pnlArbol.setPreferredSize(new java.awt.Dimension(1420, 630));
        pnlArbol.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel9.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel9.setMinimumSize(new java.awt.Dimension(1571, 807));
        jPanel9.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel18.setFont(new java.awt.Font("Segoe UI Black", 0, 36)); // NOI18N
        jLabel18.setText("GESTION DE FLOTA");
        jPanel9.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 20, -1, -1));

        jPanel16.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "REGISTRAR NUEVO VEHICULO", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI Black", 0, 18))); // NOI18N

        jLabel22.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel22.setText("MODELO:");

        jLabel21.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel21.setText("PLACA:");

        jLabel23.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel23.setText("MARCA:");

        jLabel20.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel20.setText("PRECIO( X Dia):");

        btnRegistrarVehiculo.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        btnRegistrarVehiculo.setText("REGISTRAR VEHICULO");
        btnRegistrarVehiculo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarVehiculoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel16Layout = new javax.swing.GroupLayout(jPanel16);
        jPanel16.setLayout(jPanel16Layout);
        jPanel16Layout.setHorizontalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel16Layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnRegistrarVehiculo, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel21)
                    .addComponent(jLabel20)
                    .addComponent(jLabel23)
                    .addComponent(jLabel22)
                    .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(txtMarca, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
                        .addComponent(txtPlaca, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtModelo, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap(49, Short.MAX_VALUE))
        );
        jPanel16Layout.setVerticalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel16Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtModelo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtPlaca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25)
                .addComponent(jLabel23, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtMarca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(22, 22, 22)
                .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 74, Short.MAX_VALUE)
                .addComponent(btnRegistrarVehiculo)
                .addGap(40, 40, 40))
        );

        jPanel9.add(jPanel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 100, 390, 460));

        jPanel17.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "BUSQUEDA Y ELIMINACION RAPIDA", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI Black", 0, 18))); // NOI18N

        jLabel25.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel25.setText("Ingrese la placa a buscar:");

        btnBuscarVehiculo.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btnBuscarVehiculo.setText("BUSCAR");
        btnBuscarVehiculo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarVehiculoActionPerformed(evt);
            }
        });

        jPanel18.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Resultado de la busqueda", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI Black", 0, 14))); // NOI18N

        lblResultadoBusqueda.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        lblResultadoBusqueda.setText("Esperando búsqueda....");

        javax.swing.GroupLayout jPanel18Layout = new javax.swing.GroupLayout(jPanel18);
        jPanel18.setLayout(jPanel18Layout);
        jPanel18Layout.setHorizontalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel18Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(lblResultadoBusqueda, javax.swing.GroupLayout.PREFERRED_SIZE, 420, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(29, Short.MAX_VALUE))
        );
        jPanel18Layout.setVerticalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel18Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblResultadoBusqueda, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(24, Short.MAX_VALUE))
        );

        btnEliminarVehiculo.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btnEliminarVehiculo.setText("ELIMINAR");
        btnEliminarVehiculo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarVehiculoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel17Layout = new javax.swing.GroupLayout(jPanel17);
        jPanel17.setLayout(jPanel17Layout);
        jPanel17Layout.setHorizontalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel17Layout.createSequentialGroup()
                .addGap(100, 100, 100)
                .addComponent(btnBuscarVehiculo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnEliminarVehiculo)
                .addGap(103, 103, 103))
            .addGroup(jPanel17Layout.createSequentialGroup()
                .addGap(121, 121, 121)
                .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtBuscarPlaca, javax.swing.GroupLayout.PREFERRED_SIZE, 290, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel17Layout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addComponent(jLabel25)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel17Layout.createSequentialGroup()
                .addContainerGap(32, Short.MAX_VALUE)
                .addComponent(jPanel18, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(23, 23, 23))
        );
        jPanel17Layout.setVerticalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel17Layout.createSequentialGroup()
                .addComponent(jLabel25)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtBuscarPlaca, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnBuscarVehiculo)
                    .addComponent(btnEliminarVehiculo))
                .addGap(37, 37, 37)
                .addComponent(jPanel18, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(45, Short.MAX_VALUE))
        );

        jPanel9.add(jPanel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 180, 550, 390));

        pnlArbol.add(jPanel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(7, 0, 1260, 630));

        pnlContenedorVistas.add(pnlArbol, "card6");

        pnlInicio.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel4.setFont(new java.awt.Font("Segoe UI Black", 0, 36)); // NOI18N
        jLabel4.setText("RESUMEN OPERATIVO DE LA AGENCIA");
        jPanel4.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 30, 729, 50));

        pnlCardEspera.setBackground(new java.awt.Color(255, 255, 255));
        pnlCardEspera.setPreferredSize(new java.awt.Dimension(350, 140));

        jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel7.setText("Clientes en Fila");

        lblEnEspera.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        lblEnEspera.setText("0");

        javax.swing.GroupLayout pnlCardEsperaLayout = new javax.swing.GroupLayout(pnlCardEspera);
        pnlCardEspera.setLayout(pnlCardEsperaLayout);
        pnlCardEsperaLayout.setHorizontalGroup(
            pnlCardEsperaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlCardEsperaLayout.createSequentialGroup()
                .addContainerGap(109, Short.MAX_VALUE)
                .addComponent(jLabel7)
                .addGap(118, 118, 118))
            .addGroup(pnlCardEsperaLayout.createSequentialGroup()
                .addGap(131, 131, 131)
                .addComponent(lblEnEspera)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnlCardEsperaLayout.setVerticalGroup(
            pnlCardEsperaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlCardEsperaLayout.createSequentialGroup()
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblEnEspera)
                .addContainerGap(36, Short.MAX_VALUE))
        );

        jPanel4.add(pnlCardEspera, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 140, 320, 110));

        pnlCardFlota.setBackground(new java.awt.Color(255, 255, 255));
        pnlCardFlota.setPreferredSize(new java.awt.Dimension(350, 140));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel5.setText("Vehiculos registrados en total");

        lblTotalFlota.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        lblTotalFlota.setText("0");

        javax.swing.GroupLayout pnlCardFlotaLayout = new javax.swing.GroupLayout(pnlCardFlota);
        pnlCardFlota.setLayout(pnlCardFlotaLayout);
        pnlCardFlotaLayout.setHorizontalGroup(
            pnlCardFlotaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlCardFlotaLayout.createSequentialGroup()
                .addGroup(pnlCardFlotaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlCardFlotaLayout.createSequentialGroup()
                        .addGap(37, 37, 37)
                        .addComponent(jLabel5))
                    .addGroup(pnlCardFlotaLayout.createSequentialGroup()
                        .addGap(98, 98, 98)
                        .addComponent(lblTotalFlota)))
                .addContainerGap(55, Short.MAX_VALUE))
        );
        pnlCardFlotaLayout.setVerticalGroup(
            pnlCardFlotaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlCardFlotaLayout.createSequentialGroup()
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblTotalFlota)
                .addContainerGap(32, Short.MAX_VALUE))
        );

        jPanel4.add(pnlCardFlota, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 140, 279, 110));

        pnlCardRentados.setBackground(new java.awt.Color(255, 255, 255));
        pnlCardRentados.setPreferredSize(new java.awt.Dimension(350, 140));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel6.setText("Vehículos Rentados");

        lblRentados.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        lblRentados.setText("0");

        javax.swing.GroupLayout pnlCardRentadosLayout = new javax.swing.GroupLayout(pnlCardRentados);
        pnlCardRentados.setLayout(pnlCardRentadosLayout);
        pnlCardRentadosLayout.setHorizontalGroup(
            pnlCardRentadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlCardRentadosLayout.createSequentialGroup()
                .addGroup(pnlCardRentadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlCardRentadosLayout.createSequentialGroup()
                        .addGap(77, 77, 77)
                        .addComponent(jLabel6))
                    .addGroup(pnlCardRentadosLayout.createSequentialGroup()
                        .addGap(118, 118, 118)
                        .addComponent(lblRentados)))
                .addContainerGap(99, Short.MAX_VALUE))
        );
        pnlCardRentadosLayout.setVerticalGroup(
            pnlCardRentadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlCardRentadosLayout.createSequentialGroup()
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblRentados)
                .addContainerGap(36, Short.MAX_VALUE))
        );

        jPanel4.add(pnlCardRentados, new org.netbeans.lib.awtextra.AbsoluteConstraints(900, 140, 300, 110));

        jPanel10.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Próximos clientes a atender", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI Black", 0, 14))); // NOI18N

        tblProximos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "TURNO", "CLIENTE"
            }
        ));
        jScrollPane3.setViewportView(tblProximos);

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 1080, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(27, Short.MAX_VALUE))
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(32, Short.MAX_VALUE))
        );

        jPanel4.add(jPanel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 280, 1160, 270));

        pnlInicio.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 1260, 630));

        pnlContenedorVistas.add(pnlInicio, "card2");

        jPanel1.add(pnlContenedorVistas, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 67, -1, 630));

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));

        lblEstadoSistema.setBackground(new java.awt.Color(255, 255, 255));
        lblEstadoSistema.setFont(new java.awt.Font("Segoe UI Black", 0, 24)); // NOI18N
        lblEstadoSistema.setText("Estado: Sistema iniciado correctamente.");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap(617, Short.MAX_VALUE)
                .addComponent(lblEstadoSistema, javax.swing.GroupLayout.PREFERRED_SIZE, 816, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(247, 247, 247))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(lblEstadoSistema)
                .addContainerGap(26, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(-3, 715, 1680, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 780));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtNombresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNombresActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNombresActionPerformed

    private void btnInicioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInicioActionPerformed
        pnlContenedorVistas.removeAll();
        pnlContenedorVistas.add(pnlInicio);
        pnlContenedorVistas.repaint();
        pnlContenedorVistas.revalidate();
        lblEstadoSistema.setText("Estado: Mostrando Resumen Operativo.");
        actualizarDashboard();
    }//GEN-LAST:event_btnInicioActionPerformed

    private void btnVentanillaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVentanillaActionPerformed
        pnlContenedorVistas.removeAll();
        pnlContenedorVistas.add(pnlVentanilla);
        pnlContenedorVistas.repaint();
        pnlContenedorVistas.revalidate();
        lblEstadoSistema.setText("Estado: Mostrando Sala de Espera.");
    }//GEN-LAST:event_btnVentanillaActionPerformed

    private void btnCatalogoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCatalogoActionPerformed
        pnlContenedorVistas.removeAll();
        pnlContenedorVistas.add(pnlCatalogo);
        pnlContenedorVistas.repaint();
        pnlContenedorVistas.revalidate();
        lblEstadoSistema.setText("Estado: Mostrando Catálogo de Vehículos.");
    }//GEN-LAST:event_btnCatalogoActionPerformed

    private void btnHistorialActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHistorialActionPerformed
        pnlContenedorVistas.removeAll();
        pnlContenedorVistas.add(pnlHistorial);
        pnlContenedorVistas.repaint();
        pnlContenedorVistas.revalidate();
        lblEstadoSistema.setText("Estado: Mostrando Historial de Transacciones.");
    }//GEN-LAST:event_btnHistorialActionPerformed

    private void btnArbolActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnArbolActionPerformed
        pnlContenedorVistas.removeAll();
        pnlContenedorVistas.add(pnlArbol);
        pnlContenedorVistas.repaint();
        pnlContenedorVistas.revalidate();
        lblEstadoSistema.setText("Estado: Mostrando Gestión de Flota.");
    }//GEN-LAST:event_btnArbolActionPerformed

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        // Pregunta al usuario antes de cerrar
        int respuesta = javax.swing.JOptionPane.showConfirmDialog(this,
                "¿Está seguro que desea salir del sistema?\nSe guardarán todos los cambios automáticamente.",
                "Confirmar Salida",
                javax.swing.JOptionPane.YES_NO_OPTION,
                javax.swing.JOptionPane.QUESTION_MESSAGE);

        if (respuesta == javax.swing.JOptionPane.YES_OPTION) {
            // Guarda los datos y cierra
            pe.com.autorenta.logistica.infrastructure.structure.GestorPersistencia.guardarDatos(gestor);
            System.exit(0);
        }
    }//GEN-LAST:event_btnSalirActionPerformed

    private void btnAgregarColaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarColaActionPerformed
        String dni = txtDni.getText().trim();
        String nombres = txtNombres.getText().trim();
        String apellidos = txtApellidos.getText().trim();

        if (dni.isEmpty() || nombres.isEmpty() || apellidos.isEmpty()) {
            lblEstadoSistema.setText("Error: Todos los campos son obligatorios.");
            return;
        }

        if (dni.length() != 8) {
            lblEstadoSistema.setText("Error: El DNI debe tener exactamente 8 dígitos.");
            javax.swing.JOptionPane.showMessageDialog(this,
                    "El DNI ingresado es inválido o está incompleto.\nDebe contener exactamente 8 dígitos numéricos.",
                    "DNI Inválido",
                    javax.swing.JOptionPane.ERROR_MESSAGE);
            return;
        }

        String nombreCompleto = nombres + " " + apellidos;
        gestor.registrarLlegadaCliente(dni, nombreCompleto);

        txtNombres.setText("");
        txtApellidos.setText("");
        txtDni.setText("");

        actualizarTablaCola();
        lblEstadoSistema.setText("Estado: Cliente " + nombreCompleto + " agregado a la cola.");

    }//GEN-LAST:event_btnAgregarColaActionPerformed

    private void btnLlamarTurnoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLlamarTurnoActionPerformed
        if (lblVentanilla.getText().contains("OCUPADA")) {
            // Actualiza la barra de estado
            lblEstadoSistema.setText("Error: Debe terminar de atender al cliente actual antes de llamar a otro.");
            // Lanza el mensaje emergente en el centro de la pantalla
            javax.swing.JOptionPane.showMessageDialog(this, 
                    "Ya hay un cliente en la ventanilla.\nDebe terminar su atención antes de llamar al siguiente turno.", 
                    "Ventanilla Ocupada", 
                    javax.swing.JOptionPane.WARNING_MESSAGE);
            return;
        }

        pe.com.autorenta.logistica.domain.Cliente clienteEnAtencion = gestor.llamarSiguienteCliente();

        if (clienteEnAtencion != null) {
            lblClienteActual.setText(clienteEnAtencion.getNombre() + " - DNI: " + clienteEnAtencion.getDni());
            lblVentanilla.setText("Ventanilla actual: OCUPADA");
            actualizarTablaCola();
            lblEstadoSistema.setText("Estado: Atendiendo en ventanilla a " + clienteEnAtencion.getNombre());

            btnCatalogo.doClick(); 

        } else {
            lblEstadoSistema.setText("Estado: No hay clientes esperando en la agencia.");
            lblClienteActual.setText("--- Ninguno ---");
            lblVentanilla.setText("Ventanilla actual: LIBRE");
        }
    }//GEN-LAST:event_btnLlamarTurnoActionPerformed

    private void btnRegistrarVehiculoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarVehiculoActionPerformed
        String placa = txtPlaca.getText().trim().toUpperCase();
        String marca = txtMarca.getText().trim();
        String modelo = txtModelo.getText().trim();
        String precioStr = txtPrecio.getText().trim();

        if (placa.isEmpty() || marca.isEmpty() || modelo.isEmpty() || precioStr.isEmpty()) {
            lblEstadoSistema.setText("Error: Todos los campos del vehículo son obligatorios.");
            return;
        }

        // VERIFICA SI LA PLACA YA EXISTE 
        pe.com.autorenta.logistica.domain.Vehiculo existe = gestor.buscarVehiculo(placa);
        if (existe != null) {
            lblEstadoSistema.setText("Error: La placa " + placa + " ya se encuentra registrada en el sistema.");
            javax.swing.JOptionPane.showMessageDialog(this,
                    "El vehículo con la placa " + placa + " ya existe en la flota.\nPor favor, verifique los datos ingresados.",
                    "Placa Duplicada",
                    javax.swing.JOptionPane.WARNING_MESSAGE);
            return; // Detiene el registro para que no se guarde
        }

        try {
            double precio = Double.parseDouble(precioStr);
            gestor.registrarNuevoVehiculo(placa, marca, modelo, precio);

            txtPlaca.setText("");
            txtMarca.setText("");
            txtModelo.setText("");
            txtPrecio.setText("");

            actualizarTablaCatalogo("Todas", false);
            actualizarDashboard();
            lblEstadoSistema.setText("Estado: Vehículo " + placa + " registrado exitosamente en la Flota.");
        } catch (NumberFormatException e) {
            lblEstadoSistema.setText("Error: El precio debe ser un valor numérico.");
        }

    }//GEN-LAST:event_btnRegistrarVehiculoActionPerformed

    private void btnOrdenarPrecioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOrdenarPrecioActionPerformed
        gestor.ordenarVehiculosPorPrecio();
        String marcaSeleccionada = cbxFiltroMarca.getSelectedItem().toString();
        actualizarTablaCatalogo(marcaSeleccionada, true);
        lblEstadoSistema.setText("Estado: Catálogo ordenado por precio.");
    }//GEN-LAST:event_btnOrdenarPrecioActionPerformed

    private void btnRentarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRentarActionPerformed
        int filaSeleccionada = tblCatalogo.getSelectedRow();
        if (filaSeleccionada == -1) {
            lblEstadoSistema.setText("Error: Seleccione un vehículo.");
            return;
        }

        int respuesta = javax.swing.JOptionPane.showConfirmDialog(this,
                "¿Está seguro de que desea rentar este vehículo al cliente actual?",
                "Confirmar Renta",
                javax.swing.JOptionPane.YES_NO_OPTION,
                javax.swing.JOptionPane.QUESTION_MESSAGE);

        if (respuesta == javax.swing.JOptionPane.YES_OPTION) {
            String placa = tblCatalogo.getValueAt(filaSeleccionada, 0).toString();
            boolean exito = gestor.rentarVehiculo(placa);

            if (exito) {
                // Actualizamos las tablas
                actualizarTablaCatalogo(cbxFiltroMarca.getSelectedItem().toString(), false);
                actualizarTablaHistorial();
                actualizarDashboard();

                lblClienteActual.setText("--- Ninguno ---");
                lblVentanilla.setText("Ventanilla actual: LIBRE"); // Esto permite llamar al siguiente

                lblEstadoSistema.setText("Éxito: Vehículo rentado y atención finalizada.");
                javax.swing.JOptionPane.showMessageDialog(this, "Vehículo rentado exitosamente.\n La ventanilla esta libre para el siguiente cliente.");
            } else {
                lblEstadoSistema.setText("Error al rentar el vehículo.");
                javax.swing.JOptionPane.showMessageDialog(this, "Error: No se pudo rentar el vehículo.\n Asegúrese de estar atendiendo a un cliente en Ventanilla ", "Error", javax.swing.JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_btnRentarActionPerformed

    private void cbxFiltroMarcaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxFiltroMarcaActionPerformed
        String marcaSeleccionada = cbxFiltroMarca.getSelectedItem().toString();
        actualizarTablaCatalogo(marcaSeleccionada, false);
        lblEstadoSistema.setText("Estado: Catálogo filtrado por " + marcaSeleccionada + ".");
    }//GEN-LAST:event_cbxFiltroMarcaActionPerformed
    private boolean confirmarRenta = false;
    private void btnDeshacerUltimoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeshacerUltimoActionPerformed
        if (gestor.getPilaHistorial() == null || gestor.getPilaHistorial().getCima() == null) {
            lblEstadoSistema.setText("Aviso: El historial está vacío.");
            return;
        }

        int respuesta = javax.swing.JOptionPane.showConfirmDialog(this,
                "¿Estás seguro de querer eliminar este registro de alquiler y devolver el auto?",
                "Confirmar eliminación",
                javax.swing.JOptionPane.YES_NO_OPTION,
                javax.swing.JOptionPane.WARNING_MESSAGE);

        if (respuesta == javax.swing.JOptionPane.YES_OPTION) {
            boolean exito = gestor.deshacerUltimaAccion();

            if (exito) {
                actualizarTablaHistorial();
                actualizarTablaCatalogo(cbxFiltroMarca.getSelectedItem().toString(), false);
                actualizarDashboard();

                lblEstadoSistema.setText("Estado: Registro eliminado. Vehículo devuelto.");
                javax.swing.JOptionPane.showMessageDialog(this, "El registro se eliminó correctamente y el vehículo vuelve a estar disponible.");
            } else {
                lblEstadoSistema.setText("Error: No se pudo deshacer la acción.");
            }
        }
    }//GEN-LAST:event_btnDeshacerUltimoActionPerformed

    private void btnBuscarVehiculoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarVehiculoActionPerformed
        String placa = txtBuscarPlaca.getText().trim().toUpperCase();

        if (placa.isEmpty()) {
            lblResultadoBusqueda.setText("Error: Ingrese una placa.");
            return;
        }

        pe.com.autorenta.logistica.domain.Vehiculo encontrado = gestor.buscarVehiculo(placa);

        if (encontrado != null && encontrado.isEstadoLogico()) {
            // Verifica si está libre o rentado para ponerle un color
            String estado = (encontrado.getClienteRentado() == null) ? "<font color='#16a34a'>DISPONIBLE</font>" : "<font color='#dc2626'>RENTADO</font>";

            // Diseña un cuadro de texto en HTML para que se vea espectacular en el JLabel
            String mensajeElegante = "<html>"
                    + "<b style='color:#0f172a; font-size:16px;'>✅ Vehículo Encontrado:</b><br>"
                    + "<span style='color:#334155; font-size:13px;'>"
                    + "<b>" + encontrado.getMarca() + " " + encontrado.getModelo() + "</b> (Placa: " + encontrado.getPlaca() + ")<br>"
                    + "Tarifa: <b>S/ " + encontrado.getPrecio() + "</b> por día | Estado: <b>" + estado + "</b>"
                    + "</span></html>";

            lblResultadoBusqueda.setText(mensajeElegante);
            lblEstadoSistema.setText("Estado: Búsqueda exitosa.");
        } else {
            // Mensaje si no lo encuentra o si está dado de baja
            lblResultadoBusqueda.setText("<html><b style='color:#dc2626;'>❌ Vehículo no encontrado</b><br><span style='font-size:12px;'>La placa ingresada no existe en el sistema o el vehículo fue dado de baja.</span></html>");
            lblEstadoSistema.setText("Estado: Búsqueda finalizada sin resultados.");
        }
    }//GEN-LAST:event_btnBuscarVehiculoActionPerformed

    private void btnExportarPDFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExportarPDFActionPerformed
// Verifica si la tabla tiene datos
        if (tblHistorial.getRowCount() == 0) {
            javax.swing.JOptionPane.showMessageDialog(this, "El historial está vacío. No hay nada que exportar.", "Aviso", javax.swing.JOptionPane.WARNING_MESSAGE);
            return;
        }

        // Abre una ventana para que el usuario elija dónde guardar el archivo
        javax.swing.JFileChooser ventanaGuardar = new javax.swing.JFileChooser();
        ventanaGuardar.setDialogTitle("Guardar Historial como PDF");
        ventanaGuardar.setSelectedFile(new java.io.File("Historial_PrimeDrive.pdf")); // Nombre por defecto

        // Solo se ejecuta si el usuario hace clic en el botón "Guardar" de esa ventana
        if (ventanaGuardar.showSaveDialog(this) == javax.swing.JFileChooser.APPROVE_OPTION) {

            // Obtiene la ruta exacta que eligió el usuario
            java.io.File archivoElegido = ventanaGuardar.getSelectedFile();
            String rutaDestino = archivoElegido.getAbsolutePath();

            // Si el usuario olvidó poner ".pdf" al final, el sistema se lo agrega automáticamente
            if (!rutaDestino.toLowerCase().endsWith(".pdf")) {
                rutaDestino += ".pdf";
            }

            try {
                // Inicia el documento PDF
                com.itextpdf.text.Document documento = new com.itextpdf.text.Document();
                com.itextpdf.text.pdf.PdfWriter.getInstance(documento, new java.io.FileOutputStream(rutaDestino));
                documento.open();

                // Crea el título del PDF
                com.itextpdf.text.Font fuenteTitulo = new com.itextpdf.text.Font(com.itextpdf.text.Font.FontFamily.HELVETICA, 18, com.itextpdf.text.Font.BOLD);
                com.itextpdf.text.Paragraph titulo = new com.itextpdf.text.Paragraph("Historial de Alquileres - PrimeDrive\n\n", fuenteTitulo);
                titulo.setAlignment(com.itextpdf.text.Element.ALIGN_CENTER);
                documento.add(titulo);

                // Crea la tabla para el PDF con 4 columnas
                com.itextpdf.text.pdf.PdfPTable tablaPdf = new com.itextpdf.text.pdf.PdfPTable(4);
                tablaPdf.setWidthPercentage(100);

                // Asigna los anchos de cada columna
                float[] anchos = {15f, 25f, 15f, 45f};
                tablaPdf.setWidths(anchos);

                // Nombres de las cabeceras
                String[] cabeceras = {"TIPO", "VEHÍCULO", "PLACA", "CLIENTE"};
                com.itextpdf.text.Font fuenteCabecera = new com.itextpdf.text.Font(com.itextpdf.text.Font.FontFamily.HELVETICA, 12, com.itextpdf.text.Font.BOLD);

                // Pinta las cabeceras de la tabla en gris
                for (String cabecera : cabeceras) {
                    com.itextpdf.text.pdf.PdfPCell celda = new com.itextpdf.text.pdf.PdfPCell(new com.itextpdf.text.Phrase(cabecera, fuenteCabecera));
                    celda.setBackgroundColor(com.itextpdf.text.BaseColor.LIGHT_GRAY);
                    celda.setPadding(8);
                    tablaPdf.addCell(celda);
                }

                // Copia los datos de la tabla visual al PDF
                for (int i = 0; i < tblHistorial.getRowCount(); i++) {
                    for (int j = 0; j < 4; j++) {
                        com.itextpdf.text.pdf.PdfPCell celdaDatos = new com.itextpdf.text.pdf.PdfPCell(new com.itextpdf.text.Phrase(tblHistorial.getValueAt(i, j).toString()));
                        celdaDatos.setPadding(8);
                        tablaPdf.addCell(celdaDatos);
                    }
                }

                // Guarda y cierra el documento
                documento.add(tablaPdf);
                documento.close();

                // Lanza el mensaje de éxito
                lblEstadoSistema.setText("Estado: Historial exportado exitosamente a PDF.");
                javax.swing.JOptionPane.showMessageDialog(this, "El PDF se ha guardado exitosamente en:\n" + rutaDestino, "Exportación Exitosa", javax.swing.JOptionPane.INFORMATION_MESSAGE);

            } catch (Exception e) {
                // Lanza el mensaje de error si algo falla
                lblEstadoSistema.setText("Error: Fallo al exportar el PDF.");
                javax.swing.JOptionPane.showMessageDialog(this, "Ocurrió un error al generar el PDF:\n" + e.getMessage(), "Error", javax.swing.JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_btnExportarPDFActionPerformed

    private void btnEliminarVehiculoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarVehiculoActionPerformed
        //Obtiene la placa escrita
        String placa = txtBuscarPlaca.getText().trim().toUpperCase();

        if (placa.isEmpty()) {
            lblResultadoBusqueda.setText("Error: Ingrese una placa para dar de baja.");
            return;
        }

        // Pide el MOTIVO de la baja con un InputDialog
        String motivo = javax.swing.JOptionPane.showInputDialog(this,
                "Ingrese el motivo de la baja para el vehículo " + placa + ":\n(Ej. Mantenimiento, Siniestro, Venta)",
                "Registro de Baja",
                javax.swing.JOptionPane.WARNING_MESSAGE);

        // Valida si canceló la ventana o la dejó vacía
        if (motivo == null || motivo.trim().isEmpty()) {
            lblResultadoBusqueda.setText("Operación cancelada. Es obligatorio ingresar un motivo.");
            return;
        }

        // Pregunta si está completamente seguro
        int respuesta = javax.swing.JOptionPane.showConfirmDialog(this,
                "¿Confirmar baja definitiva del vehículo " + placa + "?\nMotivo: '" + motivo + "'",
                "Confirmar Eliminación",
                javax.swing.JOptionPane.YES_NO_OPTION,
                javax.swing.JOptionPane.ERROR_MESSAGE);

        // Si dice que SÍ, procede a borrarlo
        if (respuesta == javax.swing.JOptionPane.YES_OPTION) {

            // Llama al método de tu gestor para eliminarlo
            boolean exito = gestor.eliminarVehiculo(placa);

            if (exito) {

                pe.com.autorenta.logistica.infrastructure.structure.GestorPersistencia.guardarDatos(gestor);

                lblResultadoBusqueda.setText("Baja exitosa: " + placa + " (" + motivo + ")");
                txtBuscarPlaca.setText(""); // Limpiamos la caja

                // Actualiza las tablas y números visuales
                actualizarTablaCatalogo("Todas", false);
                actualizarDashboard();

                javax.swing.JOptionPane.showMessageDialog(this, "Vehículo eliminado correctamente.\nLos datos han sido guardados.", "Baja exitosa", javax.swing.JOptionPane.INFORMATION_MESSAGE);
                lblEstadoSistema.setText("Estado: Vehículo " + placa + " dado de baja. Cambios guardados.");
            } else {
                lblResultadoBusqueda.setText("Error: Placa no encontrada o el vehículo está alquilado.");
                javax.swing.JOptionPane.showMessageDialog(this, "No se puede eliminar un vehículo que está actualmente alquilado a un cliente.", "Acción Denegada", javax.swing.JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_btnEliminarVehiculoActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregarCola;
    private javax.swing.JButton btnArbol;
    private javax.swing.JButton btnBuscarVehiculo;
    private javax.swing.JButton btnCatalogo;
    private javax.swing.JButton btnDeshacerUltimo;
    private javax.swing.JButton btnEliminarVehiculo;
    private javax.swing.JButton btnExportarPDF;
    private javax.swing.JButton btnHistorial;
    private javax.swing.JButton btnInicio;
    private javax.swing.JButton btnLlamarTurno;
    private javax.swing.JButton btnOrdenarPrecio;
    private javax.swing.JButton btnRegistrarVehiculo;
    private javax.swing.JButton btnRentar;
    private javax.swing.JButton btnSalir;
    private javax.swing.JButton btnVentanilla;
    private javax.swing.JComboBox<String> cbxFiltroMarca;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel16;
    private javax.swing.JPanel jPanel17;
    private javax.swing.JPanel jPanel18;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JLabel lblClienteActual;
    private javax.swing.JLabel lblEnEspera;
    private javax.swing.JLabel lblEstadoSistema;
    private javax.swing.JLabel lblRentados;
    private javax.swing.JLabel lblResultadoBusqueda;
    private javax.swing.JLabel lblTituloLogo;
    private javax.swing.JLabel lblTotalFlota;
    private javax.swing.JLabel lblUsuarioActual;
    private javax.swing.JLabel lblVentanilla;
    private javax.swing.JPanel pnlArbol;
    private javax.swing.JPanel pnlCardEspera;
    private javax.swing.JPanel pnlCardFlota;
    private javax.swing.JPanel pnlCardRentados;
    private javax.swing.JPanel pnlCatalogo;
    private javax.swing.JPanel pnlContenedorVistas;
    private javax.swing.JPanel pnlHistorial;
    private javax.swing.JPanel pnlInicio;
    private javax.swing.JPanel pnlVentanilla;
    private javax.swing.JTable tblCatalogo;
    private javax.swing.JTable tblCola;
    private javax.swing.JTable tblHistorial;
    private javax.swing.JTable tblProximos;
    private java.awt.TextField txtApellidos;
    private java.awt.TextField txtBuscarPlaca;
    private java.awt.TextField txtDni;
    private java.awt.TextField txtMarca;
    private java.awt.TextField txtModelo;
    private java.awt.TextField txtNombres;
    private java.awt.TextField txtPlaca;
    private java.awt.TextField txtPrecio;
    // End of variables declaration//GEN-END:variables

}
