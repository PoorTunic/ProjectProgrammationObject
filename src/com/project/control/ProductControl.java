package com.project.control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.table.DefaultTableModel;

import com.project.model.Bed;
import com.project.model.Lift;
import com.project.model.Mattress;
import com.project.model.Product;
import com.project.model.Table;
import com.project.model.Wheelchair;
import com.project.view.ProductView;

public class ProductControl implements ActionListener, ItemListener, WindowListener {

	private Product productModel;
	private ProductView productView;
	private WriteFile writeFile;

	public ProductControl(Product productModel, ProductView productView) {
		this.productModel = productModel;
		this.productView = productView;

		productView.addWindowListener(this);
		productView.jcbProducts.addItemListener(this);
		productView.btnGarder.addActionListener(this);
		productView.btnAnnuler.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource().equals(this.productView.btnAnnuler)) {
			cleanView();
		} else if (e.getSource().equals(this.productView.btnGarder)) {

			String thypeProduct = this.productView.jcbProducts.getSelectedItem().toString();

			writeFile = new WriteFile();

			switch (thypeProduct) {
			case "Lit":

				productModel = new Bed(Double.parseDouble(this.productView.jtfLargeBed.getText()),
						Double.parseDouble(this.productView.jtfWideBed.getText()),
						Double.parseDouble(this.productView.jtfHightBed.getText()),
						Double.parseDouble(this.productView.jtfMaxWeightBed.getText()));

				break;
			case "Matelas":

				productModel = new Mattress(this.productView.jtfInfatableMattress.getText());

				break;
			case "Lift":

				productModel = new Lift(Double.parseDouble(this.productView.jtfRaisingLigt.getText()),
						Double.parseDouble(this.productView.jtfSpinLift.getText()));

				break;
			case "Wheelchair":

				productModel = new Wheelchair(Double.parseDouble(this.productView.jtfWidthChair.getText()),
						Double.parseDouble(this.productView.jtfWeight.getText()));

				break;
			case "Table":

				productModel = new Table(Double.parseDouble(this.productView.jtfWeightMaxTable.getText()),
						Double.parseDouble(this.productView.jtfLargeTable.getText()),
						Double.parseDouble(this.productView.jtfWideTable.getText()),
						Double.parseDouble(this.productView.jtfHightTable.getText()));
				break;
			default:
				productModel = null;
				break;
			}

			productModel.setNoRef(this.productView.jtfNoRef.getText());
			productModel.setMark(this.productView.jtfMark.getText());
			productModel.setModel(this.productView.jtfModel.getText());
			productModel.setPrice(Double.parseDouble(this.productView.jtfPrice.getText()));
			productModel.setStock(Integer.parseInt(this.productView.jtfStock.getText()));

			WriteFile writeFile = new WriteFile();
			writeFile.writeProduct(thypeProduct + ";" + productModel.toFile(), thypeProduct);
		}
	}

	public void cleanView() {

	}

	@Override
	public void itemStateChanged(ItemEvent e) {
		if(e.getSource().equals(this.productView.jcbProducts))){
			
		}
	}

	@Override
	public void windowActivated(WindowEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowClosed(WindowEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowClosing(WindowEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowDeactivated(WindowEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowDeiconified(WindowEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowIconified(WindowEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowOpened(WindowEvent e) {
		if (e.getSource().equals(this.productView)) {
			DefaultComboBoxModel<String> model = new DefaultComboBoxModel<>();
			model.addElement("Lit");
			model.addElement("Alite");
			model.addElement("Souleve");
			model.addElement("Fauteuil");
			model.addElement("Matelas");

			this.productView.jcbProducts.setModel(model);
		}
	}
}
