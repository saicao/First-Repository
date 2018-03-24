import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

public class DreamVacationGUI{

    /*** Complete and submit this file in AutoLab ***/

    /*** This class contains a large number of small objectives to guide you through a larger program ***/


    /**
     * The drop down menu containing all the destinations from the API allowing user to select a destination.
     * The destination selected by comboBox will referred to as the "selected destination"
     */
    private JComboBox<Destination> comboBox;

    /**
     * A spinner to choose the zoom level of the map tile. The integer selected by spinner will be referred to
     * as the "zoom level"
     */
    private JSpinner spinner;

    /**
     * The label that will contain the map tile as an image retrieved from an API
     */
    private JLabel mapLabel;

    /**
     * A text area containing the chat for the selected destination
     */
    private JTextArea chatArea;

    /**
     * A text area containing the description of the selected destination
     */
    private JTextArea descriptionArea;

    /**
     * The tile server used to retrieve map tiles
     */
    private TileServer tileServer;

    /**
     * Constructor for the GUI. This constructor is called in Main and used to assemble the JFrame.
     * Run Main for testing
     */
    public DreamVacationGUI(){
        initialize();
    }

    /**
     * Sets up all the member variables when the constructor is called. This method is only called once.
     */
    private void initialize(){
    	

        // 3 points
        // Set the instance variable comboBox to a new JComboBox and add to it all the destinations from the API.
        // See the DreamVacationAPI class for a method that can be used here
    	comboBox=new JComboBox<Destination>();
    	for(Destination e:DreamVacationAPI.getDestinations()){
    		comboBox.addItem(e);
    	}
    	

        // 1 point
        // Add an ActionListener to comboBox that calls updateDestination() (below) on an action
    	comboBox.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				updateDestination();
				
			}
		});
    	
    	


        // 1 point
        // Set the instance variable spinner to new JSpinner, then set its value to 10
        // Add a ChangeListener to spinner that calls updateDestination() (below) on a change.
        // Note: ChangeListener uses the same syntax as ActionListener but with a method named
        // stateChanged instead of actionPerformed
    	spinner=new JSpinner();
    	spinner.setValue(10);
    	spinner.addChangeListener(new ChangeListener() {
			
			@Override
			public void stateChanged(ChangeEvent e) {
				updateDestination();
				
			}
		});


        // 1 point
        // Set the instance variable mapLabel to a new JLabel
    	mapLabel=new JLabel();
        // Set the instance variable chartArea to a new JTextArea with 15 rows and 40 columns
    	chatArea=new JTextArea (15,40);
        // Set the instance variable descriptionArea to a new JTextArea with 20 rows and 40 columns
        // Set line wrap to true on both chatArea and descriptionArea by calling setLineWrap(boolean)
        // Set the instance variable tileServer equal to a new instance of your DreamVacationMap class
    
    	descriptionArea= new JTextArea(20,40);
    	chatArea.setLineWrap(true);
    	descriptionArea.setLineWrap(true);
    	tileServer=new DreamVacationMap();
    	updateDestination();
    	updateChat();
    	


        
    }


    /**
     * Called when the destination or zoom level is changed. Updates all necessary GUI elements
     */
    private void updateDestination(){
        // Read comboBox and spinner (using getValue()) then update the following:
    	Destination D=comboBox.getItemAt(comboBox.getSelectedIndex());
    	
    	
    	
    	
        // -[1 point] mapLabel to the map tile containing the selected destination at the zoom level from
        //  spinner from the tile server (These points are awarded even if the tile server isn't functional)
    	mapLabel.setIcon(tileServer.getTile(D,(int) spinner.getValue() ));
    	
    	descriptionArea.setText(D.getDescription());
        // -[1 point] descriptionArea to the description of the selected location

      
    }


    /**
     * Updates the chat area with the comments from the API for the currently selected destination
     */
    private void updateChat(){
        // 2 point
        // Read the comments from the API for the selected destination using a method from the DreamVacationAPI class
        // and set the text of chatArea to the comments separated by new lines.
    	Destination D=comboBox.getItemAt(comboBox.getSelectedIndex());
    	
    	for(String e:DreamVacationAPI.getComments(D.get_id()))
    	chatArea.append(e+"\n");

    }

    /**
     * @return A new panel containing only the mapLabel
     */
    public JPanel getMapPanel(){
        // 1 point
        // return a new panel containing only the mapLabel
    	 JPanel a=new JPanel();
    	 a.add(mapLabel);
    	
        
        return a;
    }

    /**
     * @return A new panel containing only the descriptionArea inside a JScrollPane
     */
    public JPanel getDescriptionPanel(){
        // 1 point
        // return a new panel containing only the descriptionArea inside a JScrollPane
    	JScrollPane S = new JScrollPane(descriptionArea);
    	
    	
    	JPanel a=new JPanel();
    	a.add(S);
    	

        return a;
    }


    /**
     * @return A panel containing the inputs to select and add destinations
     */
    public JPanel getControlPanel(){
        // Creates the panel to be returned
        JPanel panel = new JPanel();

        // Set the layout manager to display all components in a single column
        // (This still doesn't look great.. feel free to adjust the layout)
        panel.setLayout(new BoxLayout(panel, BoxLayout.PAGE_AXIS));


        // 1 point
        // Add a JLabel with the text "Destination:" to the panel
        panel.add(new JLabel("Destination:"));
        
        // Add the instance variable comboBox to the panel
        panel.add(comboBox);
        // Add a JLabel with the text "Zoom:" to the panel
        panel.add(new JLabel("Zoom:"));
        
        // Add the instance variable spinner to the panel
        panel.add(spinner);
        // Add a JLabel with the text "Name:" to the panel
        panel.add(new JLabel("Name:"));
        // Add a new JTextField to the panel that will be used to enter the name of a new location
        JTextField namefield  =new JTextField();
        panel.add(namefield);


        // 1 point
        // Add a JLabel with the text "Latitude:" to the panel
        panel.add(new JLabel("Latitude:"));
        
        // Add a new JTextField to the panel that will be used to enter the latitude of a new location
        JTextField latitudefield=   new JTextField();
        panel.add(latitudefield);

        // Add a JLabel with the text "Longitude:" to the panel
        panel.add(new JLabel("Longitude:"));
       JTextField longitudefield= new JTextField();
        panel.add(longitudefield);
        // Add a new JTextField to the panel that will be used to enter the longitude of a new location


        // 1 point
        // Add a new JTextArea with 10 rows to the panel that will be used to enter the description of a new location
        // Set the line wrap of the text area to true
        JTextArea textarea=  new JTextArea(10,0);
        textarea.setLineWrap(true);
        panel.add(textarea);
        
        
        // Note: with BoxLayout each component will be stretched to the panel width so there is no need to set the
        //       columns on the text area or fields on this panel


        // 2 points
      JButton button= new JButton("Submit");
      
      panel.add(button);
        
        // Add a button to the panel with the text "Submit"
        // Add a new instance of SubmitLocationListener to this button as an ActionListener. Use the three text fields
        // and one text area as arguments in the constructor call (See below for SubmitLocationListener definition)
      button.addActionListener(new SubmitLocationListener(namefield, latitudefield,longitudefield, textarea));


        return panel;
    }

    /**
     * Listens for the user to submit a new destination, reads the form, and uploads the information to the API
     */
    public class SubmitLocationListener implements ActionListener{

        // Store references to the inputs in the form used to upload a new destination
        private JTextField nameField;
        private JTextField latitudeField;
        private JTextField longitudeField;
        private JTextArea descriptionArea;

        // The appropriate GUI components must be provided when instantiating a new SubmitLocationListener
        public SubmitLocationListener(JTextField nameField, JTextField latitudeField, JTextField longitudeField, JTextArea descriptionArea){
            this.nameField = nameField;
            this.latitudeField = latitudeField;
            this.longitudeField = longitudeField;
            this.descriptionArea = descriptionArea;
        }

        @Override
        public void actionPerformed(ActionEvent e){
            // 2 points
            // Read the text fields and text area to create a new Destination with the user's information, then
            // upload this Destination to the API using a method provided in the DreamVacationAPI class
        	Destination D=new Destination(nameField.getText(), 
        			descriptionArea.getText(), 
        			new Double (latitudeField.getText()), 
        			new Double (longitudeField.getText()));
        	DreamVacationAPI.addDestination(D);
        	updateDestination();
        	

        }
    }


    /**
     * @return a panel containing the chat portion of the app
     */
    public JPanel getChatPanel(){
        JPanel panel = new JPanel();

        // 1 point
        // Add a JLabel with the text "Name:" to the panel
        JLabel name=new JLabel("Name:");
        panel.add(name);
        // Add a new JTextField with 15 columns to the panel that will be used to enter a username
        JTextField nameField = new JTextField(15);
        panel.add(nameField);

        // 1 point
        // Add the member variable chatArea to the panel in a new JScrollPane
        JScrollPane SP=new JScrollPane(chatArea);
        
       
        panel.add(SP);
        
        // Add a new JTextField with 20 columns to the panel that will be used to enter chat messages

        JTextField massage = new JTextField(20);
        panel.add(massage);

        // 2 points
        // Add a KeyListener to this text field that will post its text as a comment under the selected destination
        // and call the "updateChat()" method.
        Destination D=comboBox.getItemAt(comboBox.getSelectedIndex());
        massage.addKeyListener(new KeyListener() {
			
			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub
				if(e.getKeyCode()==e.VK_ENTER){
				DreamVacationAPI. postComment(D.get_id(), nameField.getText(), 
						massage.getText());
				
				updateChat();
				}
				
			}
			
			@Override
			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub
				if(e.getKeyCode()==e.VK_ENTER){
					DreamVacationAPI. postComment(D.get_id(), nameField.getText(), 
							massage.getText());
					
					updateChat();
					}
				
			}
		});
        
        // There is a method to connect to the API in DreamVacationAPI. Be sure the pull the username from the
        // previous text field as well as the comment from the current text field.


        // 1 point
        // Add a button to the panel with the text "Send"
        JButton send=new JButton("Send");
        send.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				DreamVacationAPI. postComment(D.get_id(), nameField.getText(), 
						massage.getText());
				
				
				updateChat();
			}
		});
        // Add an ActionListener to this button with the same functionality as the previous KeyListener

        panel.add(send);

        // 1 point
        // Add another button to the panel with the text "Refresh"
        JButton Refresh=new JButton("Refresh");
        Refresh.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				updateChat();
			}
		});
        // Add an ActionListener to this button that only calls "updateChat()"
        panel.add(Refresh);


        return panel;
    }

}
