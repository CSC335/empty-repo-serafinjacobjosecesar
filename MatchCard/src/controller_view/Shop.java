package controller_view;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import model.Account;

public class Shop extends BorderPane{
	private BorderPane shopPane = new BorderPane();
	private Label cardSkins = new Label("Card Skins");
	private Button[] items = new Button[12];
	public Button returnMainMenu = new Button("Main Menu");
	private Button cardPreview = new Button();
	private Label pointsAvaliable;
	private Account currAccount;
	private int cardPrice = 100;
	private int backgroundPrice = 200;
	private Label tier1 = new Label("Tier 1");
	private Label tier2 = new Label("Tier 2");
	private Label tier3 = new Label("Tier 3");
	private Label sysReply = new Label("");
	
	public Shop(Account account) {
		
		cardPreview.setPrefSize(100, 100);
		if(account.getBack()!=null) {
			Image back = new Image(account.getBack());
			ImageView backView = new ImageView(back);
			cardPreview.setGraphic(backView);
		}
		
		for(int i=0; i<12;i++) {
			items[i] = new Button();
		}

		currAccount = account;
		pointsAvaliable = new Label("Points: " + currAccount.getPoints());
		configLayout();
		buttonHandlers();
		returnMainMenu.setOnAction(event -> {});
	}

	private void configLayout() {
		tier1.setAlignment(Pos.CENTER);
		tier2.setAlignment(Pos.CENTER);
		tier3.setAlignment(Pos.CENTER);
		HBox tier1Row = new HBox();
		HBox tier2Row = new HBox();
		HBox tier3Row = new HBox();	
		VBox shopContainer = new VBox();
		
		itemSetting();
		for(Button currItem: items) {
			if(currItem.getId().contains("-fx-background-color:")) {
				currItem.setPrefSize(100, 100);
				String background = currItem.getId();
				currItem.setStyle(background);
			}
			else {
				String cardBack = currItem.getId();
				Image cardBackImg = getFileName(cardBack,100);
				ImageView cardBackView = new ImageView(cardBackImg);
				currItem.setGraphic(cardBackView);
			}
		}
		
		
		
		tier1Row.getChildren().addAll(items[0],items[1],items[2],items[3]);
		tier2Row.getChildren().addAll(items[4],items[5],items[6],items[7]);
		tier3Row.getChildren().addAll(items[8],items[9],items[10],items[11]);
		shopContainer.getChildren().addAll(pointsAvaliable, cardPreview,sysReply,tier1,tier1Row,
											tier2,tier2Row,tier3,tier3Row, returnMainMenu);
		tier1Row.setAlignment(Pos.CENTER);
		tier2Row.setAlignment(Pos.CENTER);
		tier3Row.setAlignment(Pos.CENTER);
		shopContainer.setAlignment(Pos.CENTER);
		
		
		shopPane.setCenter(shopContainer);
		this.setCenter(shopPane);
	}
	
	private void buttonHandlers() {
		for (Button currItem : items)  {
				currItem.setOnAction(event -> {
					
					
					if(!currAccount.inventory.contains(currItem.getId())) {
						int price = getPrice(currItem);
						if(currAccount.getPoints()>=price) {
							purchase(price);
							setItem(currItem);
							currAccount.inventory.add(currItem.getId());
							updatePoints();
						}
					}
					else {
						setItem(currItem);
					}
					
				});
		}
		
	}
	
	private void setItem(Button currItem) {
		if(currItem.getId().contains("-fx-background-color:")) {
			String background = currItem.getId();
			currAccount.setCurrBackground(background);
			this.setStyle(background);
		}
		else {
				String cardBack = currItem.getId();
				currAccount.setCurrCardBack(cardBack);
				
				Image cardBackImg = getFileName(cardBack,100);
				ImageView cardBackView = new ImageView(cardBackImg);
				cardPreview.setGraphic(cardBackView);
				
				}
		}
	
	private int getPrice(Button currItem) {
		if(currItem.getId().contains("-fx-background-color:")) {
			return backgroundPrice;
			}
		return cardPrice;
		}
	
	private void purchase(int price) {
		currAccount.withdrawPoints(price);
		updatePoints();
	}
	
	private void updatePoints() {
		pointsAvaliable.setText("Points: " + currAccount.getPoints());
	}
	
	private void itemSetting() {
		
		//tier 1
		items[0].setId("blackAndWhite(back_uneditted)");
		items[1].setId("CartoonStyle(back_uneditted)");
		items[2].setId("-fx-background-color: #61ab8c;");
		items[3].setId("-fx-background-color: #61ab8c;");
		
		//tier 2
		items[4].setId("cyberPunk(back_uneditted)");
		items[5].setId("EightBit(back_uneditted)");
		items[6].setId("-fx-background-color: #61ab8c;");
		items[7].setId("-fx-background-color: #61ab8c;");
		
		//tier 3
		items[8].setId("horseAss(back_uneditted)");
		items[9].setId("steamPunk(back_uneditted)");
		items[10].setId("-fx-background-color: #61ab8c;");
		items[11].setId("-fx-background-color: #61ab8c;");
	}
	
	public Image getFileName(String str, int scale) {
		String userDir = System.getProperty("user.dir");
		String fileName = "";
		
		if (userDir.substring(0, 1).equals("/")) {
		    fileName = "file:" + userDir + "/Card Images/CardBacks/";
		} 
		else {
			userDir = userDir.replace('\\', '/');
			fileName = "file:/" + userDir + "/Card Images/CardBacks/";
		}
		Image image1 = new Image(fileName+str+".jpg",scale,scale,false,false);
		return image1;
	}	

}
