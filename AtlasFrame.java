import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JLabel;

import java.awt.Panel;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

public class AtlasFrame extends javax.swing.JFrame {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
     * Creates new form AtlasFrame
     */
    public AtlasFrame() {
    	
    	int pace = 2000;
    	pendingN = "";
    	pendingT = null;
    	
        initComponents();
        permitVoteTaxes(false);
        permitElection(false);
        permitGoverning(false);
        permitCoup(false);
        permitNationName(false);
        permitPropose(false);
        permitTravel(false);
        permitJoin(false);
        permitNewGov(false);
        
        
        Territory miller = new Territory("Miller Plains", Terrain.Farmland, Resource.Food,82,164);
		Territory high = new Territory("Highlandwood",Terrain.Forest, Resource.Wood,147,93);
		Territory sandy = new Territory("Sandy Peak",Terrain.Mountain, Resource.Metal,297,167);
		Territory rocky = new Territory("Rocky Point",Terrain.Quarry, Resource.Stone,348,122);
		Territory hop = new Territory("Hop Fields",Terrain.Farmland, Resource.Food,424,105);
		Territory titan = new Territory("Titanius",Terrain.Mountain, Resource.Metal,486,138);
		Territory gull = new Territory("Gull Cove",Terrain.River, Resource.Water,129,176);
		Territory mount = new Territory("Mount Fortune",Terrain.Quarry, Resource.Stone,214,185);
		Territory marsh = new Territory("Marshway",Terrain.River, Resource.Water,309,272);
		Territory mine = new Territory("Mineras",Terrain.Mountain, Resource.Metal,409,251);
		Territory neu = new Territory("Neuland",Terrain.Forest, Resource.Wood,519,164);
		Territory roll = new Territory("Rolling Wheat",Terrain.Farmland, Resource.Food,491,244);
		Territory meer = new Territory("Meer",Terrain.River, Resource.Water,49,347);
		Territory copper = new Territory("Copper Valley",Terrain.Mountain, Resource.Metal,104,285);
		Territory lowland = new Territory("Lowland Glades",Terrain.Forest, Resource.Wood,136,305);
		Territory skyward = new Territory("Skyward",Terrain.Farmland, Resource.Food,240,278);
		Territory granite = new Territory("Granite Hills",Terrain.Quarry, Resource.Stone,285,329);
		Territory ocean = new Territory("Oceanfront",Terrain.River, Resource.Water,407,341);
		Territory fas = new Territory("Fasquarry",Terrain.Quarry, Resource.Stone,546,312);
		Territory far = new Territory("Farshire",Terrain.Forest, Resource.Wood,499,364);
		
		
		AtlasMap.connect(miller, high);
		AtlasMap.connect(miller, gull);
		AtlasMap.connect(high, gull);
		AtlasMap.connect(high, sandy);
		AtlasMap.connect(gull, mount);
		AtlasMap.connect(high, mount);
		AtlasMap.connect(mount, sandy);
		AtlasMap.connect(sandy, rocky);
		AtlasMap.connect(rocky, hop);
		AtlasMap.connect(hop, titan);
		AtlasMap.connect(titan, neu);
		AtlasMap.connect(neu, mine);
		AtlasMap.connect(neu, roll);
		AtlasMap.connect(mine, roll);
		AtlasMap.connect(mine, ocean);
		AtlasMap.connect(ocean, far);
		AtlasMap.connect(ocean, fas);
		AtlasMap.connect(far, fas);
		AtlasMap.connect(fas, roll);
		AtlasMap.connect(gull, copper);
		AtlasMap.connect(mount, copper);
		AtlasMap.connect(mount, skyward);
		AtlasMap.connect(mount, marsh);
		AtlasMap.connect(sandy, marsh);
		AtlasMap.connect(rocky, marsh);
		AtlasMap.connect(marsh, skyward);
		AtlasMap.connect(marsh, granite);
		AtlasMap.connect(granite, skyward);
		AtlasMap.connect(copper, lowland);
		AtlasMap.connect(skyward, lowland);
		AtlasMap.connect(copper, meer);
		AtlasMap.connect(meer, lowland);
		
		AtlasMap map = new AtlasMap("Atlas");
		map.addTerritory(meer);
		map.addTerritory(lowland);
		map.addTerritory(copper);
		map.addTerritory(gull);
		map.addTerritory(miller);
		map.addTerritory(high);
		map.addTerritory(mount);
		map.addTerritory(skyward);
		map.addTerritory(granite);
		map.addTerritory(marsh);
		map.addTerritory(sandy);
		map.addTerritory(rocky);
		map.addTerritory(hop);
		map.addTerritory(titan);
		map.addTerritory(neu);
		map.addTerritory(roll);
		map.addTerritory(mine);
		map.addTerritory(ocean);
		map.addTerritory(fas);
		map.addTerritory(far);
		
		allPlayers = new ArrayList<Player>();
		Territory t = map.randomTer();
		Player[] cps = new Player[30];
		for (int i=0; i<15; i++) {
			cps[i] = new Player("cp"+i);
			cps[i].setGround(t);
			mapPanel.addPlayer(cps[i]);
			allPlayers.add(cps[i]);
		}
		for (int i=15; i<30; i++) {
			cps[i] = new Player("cp"+i);
			cps[i].setGround(map.randomTer());
			mapPanel.addPlayer(cps[i]);
			allPlayers.add(cps[i]);
		}
		
		player = new Player();
		allPlayers.add(player);
		player.setGround(map.randomTer());
		selected = player.getGround();
		updateAdjTer();
		showTerrainInfo();
		mapPanel.setUser(player);
		repaint();
		
		Timer timer = new Timer();
        timer.schedule(new TimerTask() {

            @Override
            public void run() {
                turn();
            }
        }, 0, pace);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings({"deprecation" })                       
    private void initComponents() {
    	
        mapPanel = new MapPanel();
        nationPanel2 = new java.awt.Panel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        waterTaxField = new javax.swing.JTextField();
        woodTaxField = new javax.swing.JTextField();
        stoneTaxField = new javax.swing.JTextField();
        metalTaxField = new javax.swing.JTextField();
        foodTaxField = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        noButton = new javax.swing.JButton();
        setTaxesLabel = new javax.swing.JLabel();
        yesButton = new javax.swing.JButton();
        taxPropField = new javax.swing.JTextField();
        supportField = new javax.swing.JTextField();
        submitButton = new javax.swing.JButton();
        cand1Button = new javax.swing.JButton();
        cand2Button = new javax.swing.JButton();
        cand3Button = new javax.swing.JButton();
        playerPanel = new java.awt.Panel();
        statusField = new javax.swing.JTextField();
        statusLabel = new javax.swing.JLabel();
        EnHPButton = new javax.swing.JButton();
        PrHPButton = new javax.swing.JButton();
        WeHPButton = new javax.swing.JButton();
        KnHPButton = new javax.swing.JButton();
        PoHPButton = new javax.swing.JButton();
        nameAcceptButton = new javax.swing.JButton();
        EnLabel = new javax.swing.JLabel();
        nameField = new javax.swing.JTextField();
        KnLabel = new javax.swing.JLabel();
        PoLabel = new javax.swing.JLabel();
        WeLabel = new javax.swing.JLabel();
        PrLabel = new javax.swing.JLabel();
        PointsField = new javax.swing.JTextField();
        PrField = new javax.swing.JTextField();
        PointsLabel = new javax.swing.JLabel();
        EnField = new javax.swing.JTextField();
        goalsLabel = new javax.swing.JLabel();
        KnGoalField = new javax.swing.JTextField();
        statsLabel = new javax.swing.JLabel();
        WeGoalField = new javax.swing.JTextField();
        PoGoalField = new javax.swing.JTextField();
        EnGoalField = new javax.swing.JTextField();
        PrGoalField = new javax.swing.JTextField();
        PoField = new javax.swing.JTextField();
        KnField = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        totalLabel = new javax.swing.JLabel();
        goalsTotalField = new javax.swing.JTextField();
        statsTotalField = new javax.swing.JTextField();
        WeField = new javax.swing.JTextField();
        currentPanel = new java.awt.Panel();
        curTerrainLabel = new javax.swing.JLabel();
        curTerLabel = new javax.swing.JLabel();
        curResourceField = new javax.swing.JTextField();
        curTerrainField = new javax.swing.JTextField();
        curTerField = new javax.swing.JTextField();
        curResourceLabel = new javax.swing.JLabel();
        woodTax = new javax.swing.JTextField();
        stoneTax = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        curNationField = new javax.swing.JTextField();
        woodField = new javax.swing.JTextField();
        metalField = new javax.swing.JTextField();
        stoneField = new javax.swing.JTextField();
        foodField = new javax.swing.JTextField();
        waterField = new javax.swing.JTextField();
        foodTax = new javax.swing.JTextField();
        metalTax = new javax.swing.JTextField();
        taxLabel = new javax.swing.JLabel();
        waterTax = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        adjResourceLabel = new javax.swing.JLabel();
        travelButton = new javax.swing.JButton();
        terrainField = new javax.swing.JTextField();
        adjTerLabel = new javax.swing.JLabel();
        adjTerrainLabel = new javax.swing.JLabel();
        resourceField = new javax.swing.JTextField();
        playerActionsLabel = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        adjTerList = new javax.swing.JList<String>();
        demoButton = new javax.swing.JButton();
        coupButton = new javax.swing.JButton();
        nationActionsLabel = new javax.swing.JLabel();
        citizenButton = new javax.swing.JButton();
        nationNameLabel = new javax.swing.JLabel();
        dictButton = new javax.swing.JButton();
        nationLabel = new javax.swing.JLabel();
        propNameField = new javax.swing.JTextField();
        nationNameField = new javax.swing.JTextField();
        createButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(51, 255, 51));
        setResizable(false);

        mapPanel.setMaximumSize(new java.awt.Dimension(600, 450));
        mapPanel.setPreferredSize(new java.awt.Dimension(600, 450));

        javax.swing.GroupLayout mapPanelLayout = new javax.swing.GroupLayout(mapPanel);
        mapPanel.setLayout(mapPanelLayout);
        mapPanelLayout.setHorizontalGroup(
            mapPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 600, Short.MAX_VALUE)
        );
        mapPanelLayout.setVerticalGroup(
            mapPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 450, Short.MAX_VALUE)
        );

        jLabel11.setText("Metal:");

        jLabel12.setText("Stone:");

        jLabel7.setText("Water:");

        jLabel8.setText("Food:");

        waterTaxField.setText("jTextField1");

        woodTaxField.setText("jTextField5");

        stoneTaxField.setText("jTextField4");

        metalTaxField.setText("jTextField3");

        foodTaxField.setText("jTextField2");

        jLabel13.setText("Wood:");

        noButton.setText("No");
        noButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                noButtonActionPerformed(evt);
            }
        });

        setTaxesLabel.setText("Set Taxes(%)");

        yesButton.setText("Yes");
        yesButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                yesButtonActionPerformed(evt);
            }
        });

        taxPropField.setEditable(false);
        taxPropField.setText("");

        supportField.setEditable(false);
        supportField.setText("player wants [support/vote] for ...");

        submitButton.setText("Submit");
        submitButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                submitButtonActionPerformed(evt);
            }
        });

        cand1Button.setText("cand1");
        cand1Button.setMargin(new java.awt.Insets(2, 2, 2, 2));
        cand1Button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cand1ButtonActionPerformed(evt);
            }
        });

        cand2Button.setText("cand2");
        cand2Button.setMargin(new java.awt.Insets(2, 2, 2, 2));
        cand2Button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cand2ButtonActionPerformed(evt);
            }
        });

        cand3Button.setText("cand3");
        cand3Button.setMargin(new java.awt.Insets(2, 2, 2, 2));
        cand3Button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cand3ButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout nationPanel2Layout = new javax.swing.GroupLayout(nationPanel2);
        nationPanel2.setLayout(nationPanel2Layout);
        nationPanel2Layout.setHorizontalGroup(
            nationPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, nationPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(nationPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(nationPanel2Layout.createSequentialGroup()
                        .addComponent(yesButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(noButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cand1Button, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cand2Button, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cand3Button, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(nationPanel2Layout.createSequentialGroup()
                        .addGroup(nationPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(waterTaxField, javax.swing.GroupLayout.PREFERRED_SIZE, 1, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(nationPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, 42, Short.MAX_VALUE)
                            .addComponent(foodTaxField, javax.swing.GroupLayout.PREFERRED_SIZE, 1, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(nationPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, nationPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                            .addGroup(nationPanel2Layout.createSequentialGroup()
                                .addComponent(metalTaxField, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGroup(nationPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel12, javax.swing.GroupLayout.DEFAULT_SIZE, 42, Short.MAX_VALUE)
                            .addComponent(stoneTaxField, javax.swing.GroupLayout.PREFERRED_SIZE, 1, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(nationPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(woodTaxField, javax.swing.GroupLayout.PREFERRED_SIZE, 1, Short.MAX_VALUE)
                            .addComponent(jLabel13, javax.swing.GroupLayout.DEFAULT_SIZE, 42, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(nationPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(setTaxesLabel, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(submitButton, javax.swing.GroupLayout.Alignment.TRAILING)))
                    .addComponent(taxPropField)
                    .addComponent(supportField, javax.swing.GroupLayout.Alignment.TRAILING))
                .addContainerGap())
        );
        nationPanel2Layout.setVerticalGroup(
            nationPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(nationPanel2Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(supportField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(taxPropField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(nationPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(yesButton)
                    .addComponent(noButton)
                    .addComponent(cand1Button)
                    .addComponent(cand2Button)
                    .addComponent(cand3Button))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(nationPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(nationPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel7)
                        .addComponent(jLabel8)
                        .addComponent(jLabel11)
                        .addComponent(jLabel12)
                        .addComponent(jLabel13))
                    .addComponent(setTaxesLabel))
                .addGap(15, 15, 15)
                .addGroup(nationPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(nationPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(waterTaxField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(foodTaxField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(nationPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(stoneTaxField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(woodTaxField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(submitButton)
                        .addComponent(metalTaxField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(12, Short.MAX_VALUE))
        );

        statusField.setEditable(false);
        statusField.setText("Create");

        statusLabel.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        statusLabel.setText("Status:");

        EnHPButton.setLabel("+HP");
        EnHPButton.setMargin(new java.awt.Insets(2, 2, 2, 2));
        EnHPButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EnHPButtonActionPerformed(evt);
            }
        });

        PrHPButton.setLabel("+HP");
        PrHPButton.setMargin(new java.awt.Insets(2, 2, 2, 2));
        PrHPButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PrHPButtonActionPerformed(evt);
            }
        });

        WeHPButton.setLabel("+HP");
        WeHPButton.setMargin(new java.awt.Insets(2, 2, 2, 2));
        WeHPButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                WeHPButtonActionPerformed(evt);
            }
        });

        KnHPButton.setLabel("+HP");
        KnHPButton.setMargin(new java.awt.Insets(2, 2, 2, 2));
        KnHPButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                KnHPButtonActionPerformed(evt);
            }
        });

        PoHPButton.setLabel("+HP");
        PoHPButton.setMargin(new java.awt.Insets(2, 2, 2, 2));
        PoHPButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PoHPButtonActionPerformed(evt);
            }
        });

        nameAcceptButton.setText("Accept");
        nameAcceptButton.setMargin(new java.awt.Insets(2, 2, 2, 2));
        nameAcceptButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nameAcceptButtonActionPerformed(evt);
            }
        });

        EnLabel.setText("Environment");

        nameField.setForeground(new java.awt.Color(204, 0, 0));
        nameField.setText("Name");
        nameField.setName(""); // NOI18N

        KnLabel.setText("Knowledge");

        PoLabel.setText("Power");

        WeLabel.setText("Wealth");

        PrLabel.setText("Privacy");

        PointsField.setEditable(false);
        PointsField.setText("100");

        PrField.setEditable(false);
        PrField.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        PrField.setText("0");

        PointsLabel.setText(": Points");

        EnField.setEditable(false);
        EnField.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        EnField.setText("0");

        goalsLabel.setText(": Goals");

        KnGoalField.setEditable(false);
        KnGoalField.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        KnGoalField.setText("0");

        statsLabel.setText(": Stats");

        WeGoalField.setEditable(false);
        WeGoalField.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        WeGoalField.setText("0");

        PoGoalField.setEditable(false);
        PoGoalField.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        PoGoalField.setText("0");

        EnGoalField.setEditable(false);
        EnGoalField.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        EnGoalField.setText("0");

        PrGoalField.setEditable(false);
        PrGoalField.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        PrGoalField.setText("0");

        PoField.setEditable(false);
        PoField.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        PoField.setText("0");

        KnField.setEditable(false);
        KnField.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        KnField.setText("0");

        jLabel2.setText("%");

        jLabel1.setText("%");

        totalLabel.setText("Total");

        goalsTotalField.setForeground(new java.awt.Color(0, 0, 102));
        goalsTotalField.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        goalsTotalField.setText("0");

        statsTotalField.setForeground(new java.awt.Color(0, 102, 0));
        statsTotalField.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        statsTotalField.setText("0");

        WeField.setEditable(false);
        WeField.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        WeField.setText("0");

        javax.swing.GroupLayout playerPanelLayout = new javax.swing.GroupLayout(playerPanel);
        playerPanel.setLayout(playerPanelLayout);
        playerPanelLayout.setHorizontalGroup(
                playerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, playerPanelLayout.createSequentialGroup()
                    .addComponent(nameField, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(nameAcceptButton, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                    .addComponent(statusLabel)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(statusField, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(47, Short.MAX_VALUE))
                .addGroup(playerPanelLayout.createSequentialGroup()
                    .addGroup(playerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(playerPanelLayout.createSequentialGroup()
                            .addGap(22, 22, 22)
                            .addGroup(playerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(EnHPButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(EnField)
                                .addComponent(EnGoalField))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(playerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(PrGoalField, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(PrField, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 39, Short.MAX_VALUE)
                                .addComponent(PrHPButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGap(0, 0, Short.MAX_VALUE))
                        .addGroup(playerPanelLayout.createSequentialGroup()
                            .addComponent(EnLabel)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(PrLabel)))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addGroup(playerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(WeLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 37, Short.MAX_VALUE)
                        .addComponent(WeGoalField)
                        .addComponent(WeField, javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(WeHPButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addGroup(playerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(PoLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 36, Short.MAX_VALUE)
                        .addComponent(PoGoalField)
                        .addComponent(PoField)
                        .addComponent(PoHPButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addGroup(playerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, playerPanelLayout.createSequentialGroup()
                            .addGroup(playerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(KnField, javax.swing.GroupLayout.DEFAULT_SIZE, 36, Short.MAX_VALUE)
                                .addComponent(KnGoalField)
                                .addComponent(KnHPButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGap(18, 18, 18)
                            .addGroup(playerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(playerPanelLayout.createSequentialGroup()
                                    .addGroup(playerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(goalsTotalField)
                                        .addComponent(statsTotalField))
                                    .addGap(1, 1, 1)
                                    .addGroup(playerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addGroup(playerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(statsLabel)
                                        .addComponent(goalsLabel)))
                                .addGroup(playerPanelLayout.createSequentialGroup()
                                    .addComponent(PointsField, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(PointsLabel))))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, playerPanelLayout.createSequentialGroup()
                            .addComponent(KnLabel)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(totalLabel)))
                    .addGap(0, 37, Short.MAX_VALUE))
            );
            playerPanelLayout.setVerticalGroup(
                playerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(playerPanelLayout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(playerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(nameField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(statusField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(statusLabel)
                        .addComponent(nameAcceptButton))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addGroup(playerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(EnLabel)
                        .addComponent(PrLabel)
                        .addComponent(WeLabel)
                        .addComponent(PoLabel)
                        .addComponent(KnLabel)
                        .addComponent(totalLabel))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addGroup(playerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(EnField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(PrField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(WeField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(PoField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(KnField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(statsLabel)
                        .addComponent(statsTotalField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel1))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addGroup(playerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(EnGoalField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(PrGoalField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(WeGoalField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(PoGoalField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(KnGoalField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(goalsLabel)
                        .addComponent(goalsTotalField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel2))
                    .addGroup(playerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(EnHPButton)
                        .addComponent(PrHPButton)
                        .addComponent(WeHPButton)
                        .addComponent(KnHPButton)
                        .addComponent(PoHPButton)
                        .addComponent(PointsField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(PointsLabel))
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            );

        curTerrainLabel.setText("Terrain:");

        curTerLabel.setText("Current Territory:");

        curResourceField.setEditable(false);
        curResourceField.setText("resource");

        curTerrainField.setEditable(false);
        curTerrainField.setText("terrain");

        curTerField.setEditable(false);
        curTerField.setText("origin");

        curResourceLabel.setText("Resource:");

        woodTax.setEditable(false);
        woodTax.setText("0");

        stoneTax.setEditable(false);
        stoneTax.setText("0");

        jLabel15.setText("NationName:");

        curNationField.setEditable(false);
        curNationField.setText("None");

        woodField.setEditable(false);
        woodField.setText("0");

        metalField.setEditable(false);
        metalField.setText("0");

        stoneField.setEditable(false);
        stoneField.setText("0");

        foodField.setEditable(false);
        foodField.setText("0");

        waterField.setEditable(false);
        waterField.setText("0");

        foodTax.setEditable(false);
        foodTax.setText("0");

        metalTax.setEditable(false);
        metalTax.setText("0");

        taxLabel.setText("Tax Rate(%):");

        waterTax.setEditable(false);
        waterTax.setText("0");

        jLabel9.setText("Stone:");

        jLabel10.setText("Wood:");

        jLabel3.setText("Resources:");

        jLabel4.setText("Water:");

        jLabel5.setText("Food:");

        jLabel6.setText("Metal:");

        javax.swing.GroupLayout currentPanelLayout = new javax.swing.GroupLayout(currentPanel);
        currentPanel.setLayout(currentPanelLayout);
        currentPanelLayout.setHorizontalGroup(
            currentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(currentPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(currentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, currentPanelLayout.createSequentialGroup()
                        .addGroup(currentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(curTerrainLabel)
                            .addComponent(curResourceLabel)
                            .addComponent(jLabel15))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(currentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(curTerrainField)
                            .addComponent(curResourceField)
                            .addComponent(curNationField, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, currentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(curTerLabel)
                        .addGroup(currentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(currentPanelLayout.createSequentialGroup()
                                .addGap(107, 107, 107)
                                .addComponent(foodTax, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(currentPanelLayout.createSequentialGroup()
                                .addGroup(currentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(currentPanelLayout.createSequentialGroup()
                                        .addGap(4, 4, 4)
                                        .addGroup(currentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(jLabel6)
                                            .addComponent(jLabel5)
                                            .addComponent(jLabel9)
                                            .addComponent(jLabel10)))
                                    .addComponent(jLabel4))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(currentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(stoneField, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(metalField, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(foodField, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(waterField, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(woodField, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(currentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(currentPanelLayout.createSequentialGroup()
                                        .addGap(22, 22, 22)
                                        .addComponent(waterTax, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, currentPanelLayout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(currentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(metalTax, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(stoneTax, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(woodTax, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                        .addGroup(currentPanelLayout.createSequentialGroup()
                            .addComponent(jLabel3)
                            .addGap(18, 18, 18)
                            .addComponent(taxLabel))
                        .addComponent(curTerField, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        currentPanelLayout.setVerticalGroup(
            currentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(currentPanelLayout.createSequentialGroup()
                .addComponent(curTerLabel)
                .addGap(7, 7, 7)
                .addComponent(curTerField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(currentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(curTerrainLabel)
                    .addComponent(curTerrainField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(currentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(curResourceLabel)
                    .addComponent(curResourceField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(currentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel15)
                    .addComponent(curNationField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(currentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(taxLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(currentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(waterField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(waterTax, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(currentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(foodField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(foodTax, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(3, 3, 3)
                .addGroup(currentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(metalField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(metalTax, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(3, 3, 3)
                .addGroup(currentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(stoneField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(stoneTax, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(3, 3, 3)
                .addGroup(currentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(woodField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(woodTax, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
        );

        adjResourceLabel.setText("Resource:");

        travelButton.setText("Travel");
        travelButton.setMargin(new java.awt.Insets(2, 2, 2, 2));
        travelButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                travelButtonActionPerformed(evt);
            }
        });

        terrainField.setEditable(false);
        terrainField.setText("terrain");

        adjTerLabel.setText("Adjacent Territories:");

        adjTerrainLabel.setText("Terrain:");

        resourceField.setEditable(false);
        resourceField.setText("resource");

        playerActionsLabel.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        playerActionsLabel.setText("Player Actions:");

        adjTerList.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                adjTerListMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(adjTerList);

        demoButton.setText("new Democracy");
        demoButton.setMargin(new java.awt.Insets(2, 2, 2, 2));
        demoButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                demoButtonActionPerformed(evt);
            }
        });

        coupButton.setText("Propose Coup");
        coupButton.setMargin(new java.awt.Insets(2, 2, 2, 2));
        coupButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                coupButtonActionPerformed(evt);
            }
        });

        nationActionsLabel.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        nationActionsLabel.setText("Nation Actions:");

        citizenButton.setText("Join Nation");
        citizenButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                citizenButtonActionPerformed(evt);
            }
        });


        nationNameLabel.setText("Nation Name:");

        dictButton.setText("new Dictatorship");
        dictButton.setMargin(new java.awt.Insets(2, 2, 2, 2));
        dictButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dictButtonActionPerformed(evt);
            }
        });

        nationLabel.setText("Your Nation:");

        propNameField.setText("new name");

        nationNameField.setEditable(false);
        nationNameField.setText("<none>");

        createButton.setText("Create");
        createButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                createButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(playerPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(nationLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(nationNameField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(coupButton, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(demoButton, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(dictButton, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(nationActionsLabel)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(createButton)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(nationNameLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(propNameField, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(citizenButton, javax.swing.GroupLayout.PREFERRED_SIZE, 237, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(nationPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(adjTerrainLabel)
                                            .addComponent(adjResourceLabel, javax.swing.GroupLayout.Alignment.TRAILING))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(resourceField, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(terrainField, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addComponent(travelButton, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(adjTerLabel)
                            .addComponent(playerActionsLabel))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(mapPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(currentPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(nationPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(playerPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(nationActionsLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(nationNameLabel)
                            .addComponent(propNameField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(createButton))
                        .addGap(5, 5, 5)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(demoButton)
                            .addComponent(dictButton))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(citizenButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(nationLabel)
                            .addComponent(nationNameField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(coupButton))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(playerActionsLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(adjTerLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(adjTerrainLabel)
                                    .addComponent(terrainField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(resourceField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(adjResourceLabel))
                                .addGap(61, 61, 61)
                                .addComponent(travelButton))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(mapPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(currentPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        pack();
    }// </editor-fold>                        

    private void EnHPButtonActionPerformed(java.awt.event.ActionEvent evt) {                                           
    	player.addHPEnvironment();
        showGoals();
        repaint();
    }                                          

    private void PrHPButtonActionPerformed(java.awt.event.ActionEvent evt) {                                           
    	player.addHPPrivacy();
        showGoals();
    }                                          

    private void WeHPButtonActionPerformed(java.awt.event.ActionEvent evt) {                                           
    	player.addHPWealth();
        showGoals();
    }                                          

    private void KnHPButtonActionPerformed(java.awt.event.ActionEvent evt) {                                           
    	player.addHPKnowledge();
        showGoals();
    }                                          

    private void PoHPButtonActionPerformed(java.awt.event.ActionEvent evt) {                                           
    	player.addHPPower();
        showGoals();
    }                                          

    private void nameAcceptButtonActionPerformed(java.awt.event.ActionEvent evt) {
    	player.setName(nameField.getText());
    	player.checkReady();
    	if (player.getStatus().equals("Nomad")) {
        	nameAcceptButton.setVisible(false);
        	statusField.setText(player.getStatus());
        	nameField.setEditable(false);
        }
    	checkPermissions();
    }                                                

    private void travelButtonActionPerformed(java.awt.event.ActionEvent evt) {                                             
        if (adjTerList.getSelectedValue() == null) {
        	return;
        }
        player.travel(selected);
        updateAdjTer();
        showTerrainInfo();
        updateNation();
        repaint();
    }                                            

    private void submitButtonActionPerformed(java.awt.event.ActionEvent evt) {                                             
        // TODO
    }     
    
    private void citizenButtonActionPerformed(java.awt.event.ActionEvent evt) {                                             
        if (player.getStatus().equals("Nomad")){
        	player.setNation(player.getGround().getNation());
        	player.getGround().getNation().addMember(player);
        }else {
        	player.getNation().removeMember(player);
        	player.setNation(null);
        }
    }    

    private void adjTerListMouseClicked(java.awt.event.MouseEvent evt) {   
    	if (adjTerList.getSelectedValue() == null) {
        	return;
        }
    	selected = player.getGround().getAdjacents().get(adjTerList.getSelectedIndex());
        terrainField.setText(selected.getTerrain());
        resourceField.setText(selected.getResource());
    }
    
    private void createButtonActionPerformed(java.awt.event.ActionEvent evt) {
    	if((pendingN.equals("")) && (pendingT == null)) {
    		player.promptVote();
    		pendingN = propNameField.getText();
    		pendingT = player.getGround();
    		supportField.setText(player.getName()+" proposes a new nation: "+pendingN);
    		permitVoteTaxes(true);
    		
    		Timer timer = new Timer();
    		timer.schedule(new TimerTask() {

    			@Override
    			public void run() {
    				tryNation();
            	}
    		}, 5000);
    	}else {
    		note("You already have a nation pending");
    	}
    	
    }     
    
    private void tryNation() {
    	double percent = Voter.demoVote(pendingT);
    	permitVoteTaxes(false);
    	if (percent > 50.0) {
    		Nation n = new Nation(pendingN, pendingT);
    		player.setNation(n);
    		permitNationName(true);
    		permitJoin(true);
    		updateCitizen(false);
    		updateNation();
    		note("Nation Successfully Created: "+pendingN+" @ "+percent+"%");
    		permitPropose(false);
    		statusField.setText(player.getStatus());
    	}else {
    		note("Nation creation failed @ "+percent);
    	}
    	pendingN = "";
    	pendingT = null;
    }

    private void yesButtonActionPerformed(java.awt.event.ActionEvent evt) {                                          
        player.vote(1);
        permitVoteTaxes(false);
    }                                         

    private void noButtonActionPerformed(java.awt.event.ActionEvent evt) {                                         
        player.vote(0);
        permitVoteTaxes(false);
    }                                        

    private void coupButtonActionPerformed(java.awt.event.ActionEvent evt) {                                           
        // TODO add your handling code here:
    }                                          

    private void dictButtonActionPerformed(java.awt.event.ActionEvent evt) {                                           
        // TODO add your handling code here:
    }                                          

    private void demoButtonActionPerformed(java.awt.event.ActionEvent evt) {                                           
        // TODO add your handling code here:
    }   
    
    private void cand2ButtonActionPerformed(java.awt.event.ActionEvent evt) {                                            
        // TODO add your handling code here:
    }                                           

    private void cand1ButtonActionPerformed(java.awt.event.ActionEvent evt) {                                            
        // TODO add your handling code here:
    }                                           

    private void cand3ButtonActionPerformed(java.awt.event.ActionEvent evt) {                                            
        // TODO add your handling code here:
    }    

    private void turn() {
    	for (int i=0; i<allPlayers.size(); i++) {
    		allPlayers.get(i).collect();
    	}
    	updateResources();
    }
    
    private void updateAdjTer() {
    	adjTerList.setListData(player.getGround().adjStrings());
    }
    private void updateNation() {
    	if (player.getGround().hasNation()) {
    		nationNameField.setText(player.getGround().getNation().getName());
    	}
    }
    
    private void updateResources() {
    	//stoneTaxField = ;
    	//metalTaxField = ;
    	//woodTaxField = ;
    	//waterTaxField = ;
    	//foodTaxField = ;
    	stoneField.setText(""+player.getStone());
    	waterField.setText(""+player.getWater());
    	metalField.setText(""+player.getMetal());
    	woodField.setText(""+player.getWood());
    	foodField.setText(""+player.getFood());
    }

    private void showGoals() {
    	EnGoalField.setText(""+player.getEnGoal());
    	PrGoalField.setText(""+player.getPrGoal());
    	PoGoalField.setText(""+player.getPoGoal());
    	KnGoalField.setText(""+player.getKnGoal());
    	WeGoalField.setText(""+player.getWeGoal());
    	PointsField.setText(""+player.getPoints());
    	goalsTotalField.setText(""+(player.getKnGoal()+player.getEnGoal()+player.getPoGoal()+player.getPrGoal()+player.getWeGoal()));
    	if (player.getPoints() == 0) {
    		EnHPButton.setVisible(false);
    		WeHPButton.setVisible(false);
    		PoHPButton.setVisible(false);
    		PrHPButton.setVisible(false);
    		KnHPButton.setVisible(false);
    		PointsLabel.setVisible(false);
    		PointsField.setVisible(false);
    	}
    }
    
    private void permitCoup(boolean b) {
    	coupButton.setVisible(b);
    }
    
    private void permitNationName(boolean b) {
    	nationNameField.setVisible(b);
    	nationLabel.setVisible(b);
    	createButton.setVisible(b);
    }
    
    private void permitPropose(boolean b) {
    	nationNameLabel.setVisible(b);
    	propNameField.setVisible(b);
    	createButton.setVisible(b);
    }
    
    private void permitNewGov(boolean b) {
    	demoButton.setVisible(b);
    	dictButton.setVisible(b);
    }
    
    private void permitGoverning(boolean b) {
    	jLabel7.setVisible(b);
    	jLabel8.setVisible(b);
    	jLabel11.setVisible(b);
    	jLabel12.setVisible(b);
    	jLabel13.setVisible(b);
    	setTaxesLabel.setVisible(b);
    	submitButton.setVisible(b);
    	waterTaxField.setVisible(b);
    	foodTaxField.setVisible(b);
    	stoneTaxField.setVisible(b);
    	metalTaxField.setVisible(b);
    	woodTaxField.setVisible(b);
    }
    
    private void permitJoin(boolean b) {
    	citizenButton.setVisible(b);
    }
    
    private void updateCitizen(boolean onNation) {
    	if (onNation) {
    		citizenButton.setText("Join Nation");
    	}else {
    		citizenButton.setText("Leave Nation");
    	}
    }
    
    //private void permit voteInfo(boolean b) {
    	//supportField;
    //}
    
    private void permitVoteTaxes(boolean b) {
    	taxPropField.setVisible(b);
    	yesButton.setVisible(b);
    	noButton.setVisible(b);
    }
    
    private void permitElection(boolean b) {
    	taxPropField.setVisible(b);
    	cand1Button.setVisible(b);
    	cand2Button.setVisible(b);
    	cand3Button.setVisible(b);
    }
    
    private void permitTravel(boolean b) {
    	adjTerList.setVisible(b);
    	adjTerLabel.setVisible(b);
    	adjTerrainLabel.setVisible(b);
    	adjResourceLabel.setVisible(b);
    	travelButton.setVisible(b);
    	terrainField.setVisible(b);
    	resourceField.setVisible(b);
    }
    
    private void checkPermissions() {
    	String name = player.getStatus();
    	if (name.equals("Create")) {
    		permitGoverning(false);
    		permitNationName(false);
    		permitTravel(false);
    		permitPropose(false);
    		permitCoup(false);
    		permitNewGov(false);
    		permitJoin(false);
    		permitVoteTaxes(false);
    		permitElection(false);
    	}
    	if (name.equals("Nomad")) {
    		permitGoverning(false);
    		permitPropose(true);
    		permitCoup(false);
    		permitTravel(true);
    		if (player.isOn().getNation() != null) {
    			permitJoin(true);
    			updateCitizen(false);
    		}
    	}else if (name.equals("Citizen")) {
    		permitGoverning(false);
    		permitPropose(false);
    		permitNationName(true);
    		permitTravel(true);
    		updateCitizen(false);
    		//UPDATE TO DISALLOW COUP IF IN DEMO, ALLOW COUP IF IN DICT *******
    	}else if (name.equals("President")) {
    		permitTravel(true);
    		permitGoverning(true);
    		permitPropose(false);
    		permitCoup(false);
    		permitNationName(true);
    		updateCitizen(false);
    	}else if (name.equals("Dictator")) {
    		permitTravel(true);
    		permitGoverning(true);
    		permitPropose(false);
    		permitCoup(false);
    		permitNationName(true);
    		updateCitizen(false);
    	}
    }
    private void note(String S) {
    	supportField.setVisible(true);
    	supportField.setText(S);
    }
    
    private void showTerrainInfo() {    	
    	Territory t = player.getGround();
    	curTerField.setText(t.getName());
    	curResourceField.setText(t.getResource().toString());
    	curTerrainField.setText(t.getTerrain().toString());
    	if (t.hasNation()) {
    		curNationField.setText(t.getNation().getName());
    	}else {
    		curNationField.setText("<none>");
    	}
    }
    
    public void update() {
    	
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(AtlasFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AtlasFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AtlasFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AtlasFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AtlasFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify                     
    private JTextField EnField;
    private JTextField EnGoalField;
    private JButton EnHPButton;
    private JLabel EnLabel;
    private JTextField KnField;
    private JTextField KnGoalField;
    private JButton KnHPButton;
    private JLabel KnLabel;
    private JTextField PoField;
    private JTextField PoGoalField;
    private JButton PoHPButton;
    private JLabel PoLabel;
    private JTextField PointsField;
    private JLabel PointsLabel;
    private JTextField PrField;
    private JTextField PrGoalField;
    private JButton PrHPButton;
    private JLabel PrLabel;
    private JTextField WeField;
    private JTextField WeGoalField;
    private JButton WeHPButton;
    private JLabel WeLabel;
    private JLabel adjResourceLabel;
    private JLabel adjTerLabel;
    private JList<String> adjTerList;
    private JLabel adjTerrainLabel;
    private JButton coupButton;
    private JTextField curResourceField;
    private JLabel curResourceLabel;
    private JTextField curTerField;
    private JLabel curTerLabel;
    private JTextField curTerrainField;
    private JLabel curTerrainLabel;
    private JButton demoButton;
    private JButton dictButton;
    private JTextField foodField;
    private JTextField foodTax;
    private JTextField foodTaxField;
    private JLabel goalsLabel;
    private JTextField goalsTotalField;
    private JLabel jLabel1;
    private JLabel jLabel10;
    private JLabel jLabel11;
    private JLabel jLabel12;
    private JLabel jLabel13;
    private JLabel jLabel15;
    private JLabel jLabel2;
    private JLabel jLabel3;
    private JLabel jLabel4;
    private JLabel jLabel5;
    private JLabel jLabel6;
    private JLabel jLabel7;
    private JLabel jLabel8;
    private JLabel jLabel9;
    private JScrollPane jScrollPane1;
    private JTextField curNationField;
    private JTextField metalField;
    private JTextField metalTax;
    private JTextField metalTaxField;
    private JButton nameAcceptButton;
    private JTextField nameField;
    private JLabel nationActionsLabel;
    private JLabel nationLabel;
    private JTextField nationNameField;
    private JLabel nationNameLabel;
    private JButton noButton;
    //private java.awt.JPanel mapPanel;
    private MapPanel mapPanel;
    private JLabel playerActionsLabel;
    private JTextField propNameField;
    private JTextField resourceField;
    private JLabel setTaxesLabel;
    private JLabel statsLabel;
    private JTextField statsTotalField;
    private JTextField statusField;
    private JLabel statusLabel;
    private JTextField stoneField;
    private JTextField stoneTax;
    private JTextField stoneTaxField;
    private JButton submitButton;
    private JTextField supportField;
    private JLabel taxLabel;
    private JTextField taxPropField;
    private JTextField terrainField;
    private JLabel totalLabel;
    private JButton travelButton;
    private JTextField waterField;
    private JTextField waterTax;
    private JTextField waterTaxField;
    private JTextField woodField;
    private JTextField woodTax;
    private JTextField woodTaxField;
    private JButton yesButton;
    private JButton cand1Button;
    private JButton cand2Button;
    private JButton cand3Button;
    private JButton createButton;
    private JButton citizenButton;
    private Panel nationPanel2;
    private Panel playerPanel;
    private Panel currentPanel;
    private Player player;
    private Territory selected;
    private ArrayList<Player> allPlayers;
    private String pendingN;
    private Territory pendingT;
    // End of variables declaration                   
}

