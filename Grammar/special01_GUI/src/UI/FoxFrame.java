package UI;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;
import javax.swing.Timer;
import javax.swing.border.LineBorder;

/*
 * WindowPlugin으로 GUI 구축
 * 1. 만들고 싶은 환경을 extends로 설계
 * 2. 좌측 explorer에서 파일명을 우클릭해 open with -> windowBuilder Editor실행
 * 3. 아래의 Design 페이지 이동후 구축
 * 
 * - 상속받은 환경에 따라 디자인하는것
 *  ex. JFrame 상속하면 Containers가 JFrame에 포함
 */
public class FoxFrame extends JPanel{
	MJBEngine engine;
	JButton bt_Muk;
	JButton bt_Scissor;
	JButton bt_Paper;
	JButton bt_Start;
	JTextArea text_Log;
	JLabel lbUser;
	JLabel lb_Com;
	JLabel lbUserName;
	JLabel lbComName;
	JLabel lbComAttack;
	JLabel lbUserAttack;
	JLabel lbCounter;
	Timer timer;
	JLabel lb_info;
	JButton bt_Logout;
	FrameChangeHandler m;
	JLabel lb_Rank;
	//Thread cnt = null;
	
	public FoxFrame(FrameChangeHandler m) {
		this.m = m;
		engine = new MJBEngine();
		init();
		ActionListener bsh = new Bt_StartHandler(this);
		bt_Start.addActionListener(bsh);
		bt_Muk.addActionListener(new Bt_UserHandler(this, 0));
		bt_Scissor.addActionListener(new Bt_UserHandler(this, 1));
		bt_Paper.addActionListener(new Bt_UserHandler(this, 2));
		
		lb_info = new JLabel("\uB0B4 \uC815\uBCF4");
		lb_info.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		lb_info.setHorizontalAlignment(SwingConstants.CENTER);
		lb_info.setFont(new Font("맑은 고딕", Font.BOLD, 18));
		lb_info.setBounds(97, 70, 204, 29);
		add(lb_info);
		
		bt_Logout = new JButton("\uB85C\uADF8\uC544\uC6C3");
		bt_Logout.setFont(new Font("맑은 고딕", Font.BOLD, 18));
		bt_Logout.setBounds(955, 22, 118, 44);
		add(bt_Logout);
		
		lb_info.setText(getInfo());
		
		ActionListener blh = new BtLogoutHandler(this);
		
		lb_Rank = new JLabel("\uD604\uC7AC \uB7AD\uD0B9 1\uC704 : ");
		lb_Rank.setHorizontalAlignment(SwingConstants.CENTER);
		lb_Rank.setFont(new Font("맑은 고딕", Font.BOLD, 18));
		lb_Rank.setBounds(656, 25, 260, 38);
		add(lb_Rank);
		bt_Logout.addActionListener(blh);
		lb_Rank.setText(getRank());
		lbUserName.setText(m.f.getName());
	}
	
	private void init() {


		setSize(1100, 750);
		setForeground(Color.BLACK);
		setBackground(Color.PINK);
		setSize(new Dimension(1100, 750));
		setLayout(null);
		
		JLabel label = new JLabel("\uBB35\uCC0C\uBE60 \uAC8C\uC784!!");
		label.setBounds(446, 48, 156, 71);
		label.setOpaque(true);
		label.setForeground(Color.BLACK);
		label.setBackground(new Color(240, 248, 255));
		label.setBorder(new LineBorder(new Color(0, 0, 0), 4, true));
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setFont(new Font("맑은 고딕", Font.BOLD, 21));
		add(label);
		
		lbUserName = new JLabel(" User");
		lbUserName.setBounds(153, 122, 90, 29);
		lbUserName.setOpaque(true);
		lbUserName.setBackground(new Color(255, 255, 255));
		lbUserName.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		lbUserName.setFont(new Font("맑은 고딕", Font.BOLD, 18));
		lbUserName.setHorizontalAlignment(SwingConstants.CENTER);
		add(lbUserName);
		
		lbComName = new JLabel("Computer");
		lbComName.setBounds(851, 122, 102, 29);
		lbComName.setBackground(new Color(255, 255, 255));
		lbComName.setOpaque(true);
		lbComName.setHorizontalAlignment(SwingConstants.CENTER);
		lbComName.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		lbComName.setFont(new Font("맑은 고딕", Font.BOLD, 18));
		add(lbComName);
		
		JLabel lblNewLabel_2 = new JLabel("VS");
		lblNewLabel_2.setBounds(490, 198, 70, 51);
		lblNewLabel_2.setBackground(Color.RED);
		lblNewLabel_2.setOpaque(true);
		lblNewLabel_2.setBorder(new LineBorder(new Color(0, 0, 0), 4));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setFont(new Font("맑은 고딕", Font.BOLD, 18));
		add(lblNewLabel_2);
		
		bt_Start = new JButton("Game Start!!!");
		bt_Start.setBounds(446, 435, 156, 92);
		bt_Start.setBackground(Color.RED);
		bt_Start.setBorder(new LineBorder(new Color(0, 0, 0), 3, true));
		bt_Start.setFont(new Font("맑은 고딕", Font.BOLD, 20));
		add(bt_Start);
		
		lbUser = new JLabel("\uC0AC\uC9C4 \uCD9C\uB825");
		lbUser.setBounds(72, 182, 260, 260);
		lbUser.setEnabled(false);
		lbUser.setOpaque(true);
		lbUser.setHorizontalAlignment(SwingConstants.CENTER);
		lbUser.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		lbUser.setForeground(Color.BLACK);
		add(lbUser);
		
		lb_Com = new JLabel("\uC0AC\uC9C4 \uCD9C\uB825");
		lb_Com.setBounds(769, 182, 260, 260);
		lb_Com.setOpaque(true);
		lb_Com.setHorizontalAlignment(SwingConstants.CENTER);
		lb_Com.setForeground(Color.BLACK);
		lb_Com.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		add(lb_Com);
		
		bt_Scissor = new JButton("");
		bt_Scissor.setBounds(169, 481, 74, 74);
		bt_Scissor.setEnabled(false);
		bt_Scissor.setIcon(new ImageIcon("C:\\\\Users\\\\kgitbank\\\\Desktop\\\\Eclipse\\\\smallscissors.png"));
		bt_Scissor.setBorder(new LineBorder(new Color(0, 0, 0)));
		bt_Scissor.setFont(new Font("맑은 고딕", Font.BOLD, 18));
		add(bt_Scissor);
		
		JLabel lblNewLabel_4 = new JLabel("\u203B Game Start \uBC84\uD2BC\uC744 \uB204\uB974\uBA74 \uC2DC\uAC04\uC774 \uD750\uB985\uB2C8\uB2E4.");
		lblNewLabel_4.setBounds(302, 600, 380, 25);
		lblNewLabel_4.setFont(new Font("맑은 고딕", Font.BOLD, 18));
		add(lblNewLabel_4);
		
		JLabel label_2 = new JLabel("\u203B 5\uCD08 \uC774\uB0B4\uC5D0 \uC120\uD0DD\uD558\uC9C0 \uC54A\uC73C\uBA74 \uC9D1\uB2C8\uB2E4.");
		label_2.setBounds(302, 635, 311, 25);
		label_2.setFont(new Font("맑은 고딕", Font.BOLD, 18));
		add(label_2);
		
		bt_Muk = new JButton("");
		bt_Muk.setBounds(53, 481, 74, 74);
		bt_Muk.setEnabled(false);
		bt_Muk.setIcon(new ImageIcon("C:\\Users\\kgitbank\\Desktop\\Eclipse\\smallrock.png"));
		bt_Muk.setFont(new Font("맑은 고딕", Font.BOLD, 18));
		bt_Muk.setBorder(new LineBorder(new Color(0, 0, 0)));
		add(bt_Muk);
		
		bt_Paper = new JButton("");
		bt_Paper.setBounds(282, 481, 74, 74);
		bt_Paper.setEnabled(false);
		bt_Paper.setIcon(new ImageIcon("C:\\\\Users\\\\kgitbank\\\\Desktop\\\\Eclipse\\\\smallpaper.png"));
		bt_Paper.setFont(new Font("맑은 고딕", Font.BOLD, 18));
		bt_Paper.setBorder(new LineBorder(new Color(0, 0, 0)));
		add(bt_Paper);
		
		lbCounter = new JLabel("5");
		lbCounter.setBounds(480, 312, 90, 92);
		lbCounter.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		lbCounter.setFont(new Font("맑은 고딕", Font.BOLD, 35));
		lbCounter.setHorizontalAlignment(SwingConstants.CENTER);
		lbCounter.setOpaque(true);
		add(lbCounter);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(759, 524, 279, 159);
		add(scrollPane);
		
		text_Log = new JTextArea();
		scrollPane.setViewportView(text_Log);
		text_Log.setEnabled(false);
		text_Log.setEditable(false);
		
		lbUserAttack = new JLabel("\uACF5\uACA9!!");
		lbUserAttack.setBounds(270, 123, 62, 30);
		lbUserAttack.setVisible(false);
		lbUserAttack.setBorder(new LineBorder(Color.RED, 4));
		lbUserAttack.setFont(new Font("나눔고딕 ExtraBold", Font.BOLD, 18));
		lbUserAttack.setHorizontalAlignment(SwingConstants.CENTER);
		add(lbUserAttack);
		
		lbComAttack = new JLabel("\uACF5\uACA9!!");
		lbComAttack.setBounds(769, 123, 62, 30);
		lbComAttack.setVisible(false);
		lbComAttack.setHorizontalAlignment(SwingConstants.CENTER);
		lbComAttack.setFont(new Font("나눔고딕 ExtraBold", Font.BOLD, 18));
		lbComAttack.setBorder(new LineBorder(Color.RED, 4));
		add(lbComAttack);
	}

	/*
	  public void setThread() {
	
		cnt = new Thread(new Runnable() {
			@Override
			public void run() {
				int n = 5;
				for(int i =0; i<6;i++) {
					try {
						Thread.sleep(1000);
					}catch(Exception e) {}
					lbCounter.setText(String.valueOf(n--));
				}
				text_Log.append("5초의 시간이 모두 지났습니다. 졌습니다.");;
				bt_Muk.setEnabled(false);
				bt_Scissor.setEnabled(false);
				bt_Paper.setEnabled(false);
				text_Log.setEnabled(false);
				lbUser.setEnabled(false);
				bt_Start.setEnabled(true);
				lb_Com.setEnabled(false);
				
			}
			
		});
	}
	*/
	public void setTimer() {
		ActionListener counter = new Counter(this);
		timer = new Timer(1000, counter);
		((Counter)counter).setTimer(timer);
	}
	
	public String getInfo() {
		int win =0,def=0;
		try {
			DataInputStream fis = new DataInputStream(new FileInputStream(m.f));
			fis.readUTF();
			win = fis.readInt();
			def = fis.readInt();
			fis.close();
		}catch(Exception i) {}

		return win + "승 " + def + "패";
	}
	
	public void setInfo(int data) {
		try {
			DataInputStream fis = new DataInputStream(new FileInputStream(m.f));

			String pw = fis.readUTF();
			int win = fis.readInt();
			int def = fis.readInt();
			
			if(data >0) win +=1;
			else def +=1;

			DataOutputStream dos = new DataOutputStream(new FileOutputStream(m.f));
			dos.writeUTF(pw);
			dos.writeInt(win);
			dos.writeInt(def);
			
			fis.close();
			dos.close();
		}catch(Exception i) {}
	}
	
	public String getRank() {
		File p = null;
		int win = -1;
		int def = 0;
		try {
			DataInputStream fis;
			String[] s = new File(m.f.getParent()).list();
			for(String str : s) {
				File child = new File(m.f.getParent(), str);
				fis = new DataInputStream(new FileInputStream(child));
				fis.readUTF();
				int x = fis.readInt();
				int y = fis.readInt();
				if(x > win) { 
					p = child;
					win = x;
					def = y;
				} else if(x == win) {
					if(y<def) {
						p = child;
						def = y;
					}
				}
			}
		}catch(Exception i) {}
		return "현재 1위 : " + p.getName() + "님 (" + win + "승 " + def + "패)";
	}
}

