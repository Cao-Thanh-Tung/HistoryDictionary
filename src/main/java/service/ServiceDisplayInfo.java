package service;

import java.util.LinkedList;
import java.util.List;

import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import model.Event;
import model.Festival;
import model.Model;
import model.Period;
import model.Person;
import model.Place;

public class ServiceDisplayInfo {
	public static VBox displayInfo(VBox view, Model content) {
		view.getChildren().clear();
		if(content instanceof Event) {
			view = displayEvent(view, (Event) content);
		}else if(content instanceof Festival) {
			view = displayFestival(view, (Festival) content);
		}else if(content instanceof Period) {
			view = displayPeriod(view, (Period) content);
		}else if(content instanceof Person) {
			view = displayPerson(view, (Person) content);
		}else {
			view = displayPlace(view, (Place) content);
		}
		return view;
	}
	private static VBox displayEvent(VBox view, Event content) {
		List<Label> labelList = new LinkedList<Label>();
		Label label; 
		if(content.getName() != null) {
			label = new Label("- Tên: "+ content.getName());
			label.setWrapText(true);
			labelList.add(label);
		}
		if(content.getDescription() != null) {
			label = new Label("- Mô tả: "+ content.getDescription());
			label.setWrapText(true);
			labelList.add(label);
		}
		if(content.getThoiGian() != null) {
			label = new Label("- Thời gian: "+ content.getThoiGian());
			label.setWrapText(true);
			labelList.add(label);
		}
		if(content.getDiaDiem() != null) {
			label = new Label("- Địa điểm: "+ content.getDiaDiem());
			label.setWrapText(true);
			labelList.add(label);
		}
		if(content.getKetQua() != null) {
			label = new Label("- Kết quả: "+ content.getKetQua());
			label.setWrapText(true);
			labelList.add(label);
		}
		if(content.getThamChien() != null) {
			label = new Label("- Tham chiến: "+ content.getThamChien());
			label.setWrapText(true);
			labelList.add(label);
		}
		if(content.getChiHuy() != null) {
			label = new Label("- Chỉ huy: "+ content.getChiHuy());
			label.setWrapText(true);
			labelList.add(label);
		}
		if(content.getLucLuong() != null) {
			label = new Label("- Lực lượng: "+ content.getLucLuong());
			label.setWrapText(true);
			labelList.add(label);
		}
		if(content.getTonThat() != null) {
			label = new Label("- Tổn thất: "+ content.getTonThat());
			label.setWrapText(true);
			labelList.add(label);
		}
		if(content.getEventRelated() != null) {
			label = new Label("- Các sự kiện liên quan: "+ content.getEventRelated());
			label.setWrapText(true);
			labelList.add(label);
		}
		if(content.getFestivalRelated() != null) {
			label = new Label("- Các lễ hội liên quan: "+ content.getFestivalRelated());
			label.setWrapText(true);
			labelList.add(label);
		}
		if(content.getPeriodRelated() != null) {
			label = new Label("- Các triều đại liên quan: "+ content.getPeriodRelated());
			label.setWrapText(true);
			labelList.add(label);
		}
		if(content.getPersonRelated() != null) {
			label = new Label("- Các nhân vật lịch sử liên quan: "+ content.getPersonRelated());
			label.setWrapText(true);
			labelList.add(label);
		}
		if(content.getPlaceRelated() != null) {
			label = new Label("- Các địa điểm di tích lịch sử liên quan: "+ content.getPlaceRelated());
			label.setWrapText(true);
			labelList.add(label);
		}
		view.getChildren().addAll(labelList);
		return view;
	}
	private static VBox displayFestival(VBox view, Festival content) {
		List<Label> labelList = new LinkedList<Label>();
		Label label; 
		if(content.getName() != null) {
			label = new Label("- Tên: "+ content.getName());
			label.setWrapText(true);
			labelList.add(label);
		}
		if(content.getDescription() != null) {
			label = new Label("- Mô tả: "+ content.getDescription());
			label.setWrapText(true);
			labelList.add(label);
		}
		
		if(content.getNgayBatDau() != null) {
			label = new Label("- Ngày bắt đầu: "+ content.getNgayBatDau());
			label.setWrapText(true);
			labelList.add(label);
		}
		if(content.getViTri() != null) {
			label = new Label("- Vị trí: "+ content.getViTri());
			label.setWrapText(true);
			labelList.add(label);
		}
		if(content.getLanDauToChuc() != null) {
			label = new Label("- Lần đầu tổ chức: "+ content.getLanDauToChuc());
			label.setWrapText(true);
			labelList.add(label);
		}
		if(content.getNhanVatLienQuan() != null) {
			label = new Label("- Nhân vật liên quan quan trọng: "+ content.getNhanVatLienQuan());
			label.setWrapText(true);
			labelList.add(label);
		}
		if(content.getGhiChu() != null) {
			label = new Label("- Ghi chú: "+ content.getGhiChu());
			label.setWrapText(true);
			labelList.add(label);
		}
		
		if(content.getEventRelated() != null) {
			label = new Label("- Các sự kiện liên quan: "+ content.getEventRelated());
			label.setWrapText(true);
			labelList.add(label);
		}
		if(content.getFestivalRelated() != null) {
			label = new Label("- Các lễ hội liên quan: "+ content.getFestivalRelated());
			label.setWrapText(true);
			labelList.add(label);
		}
		if(content.getPeriodRelated() != null) {
			label = new Label("- Các triều đại liên quan: "+ content.getPeriodRelated());
			label.setWrapText(true);
			labelList.add(label);
		}
		if(content.getPersonRelated() != null) {
			label = new Label("- Các nhân vật lịch sử liên quan: "+ content.getPersonRelated());
			label.setWrapText(true);
			labelList.add(label);
		}
		if(content.getPlaceRelated() != null) {
			label = new Label("- Các địa điểm di tích lịch sử liên quan: "+ content.getPlaceRelated());
			label.setWrapText(true);
			labelList.add(label);
		}
		view.getChildren().addAll(labelList);
		return view;
	}
	private static VBox displayPeriod(VBox view, Period content) {
		List<Label> labelList = new LinkedList<Label>();
		Label label; 
		if(content.getName() != null) {
			label = new Label("- Tên: "+ content.getName());
			label.setWrapText(true);
			labelList.add(label);
		}
		if(content.getDescription() != null) {
			label = new Label("- Mô tả: "+ content.getDescription());
			label.setWrapText(true);
			labelList.add(label);
		}
		
		if(content.getTime() != null) {
			label = new Label("- Thời gian: "+ content.getTime());
			label.setWrapText(true);
			labelList.add(label);
		}
		
		if(content.getEventRelated() != null) {
			label = new Label("- Các sự kiện liên quan: "+ content.getEventRelated());
			label.setWrapText(true);
			labelList.add(label);
		}
		if(content.getFestivalRelated() != null) {
			label = new Label("- Các lễ hội liên quan: "+ content.getFestivalRelated());
			label.setWrapText(true);
			labelList.add(label);
		}
		if(content.getPeriodRelated() != null) {
			label = new Label("- Các triều đại liên quan: "+ content.getPeriodRelated());
			label.setWrapText(true);
			labelList.add(label);
		}
		if(content.getPersonRelated() != null) {
			label = new Label("- Các nhân vật lịch sử liên quan: "+ content.getPersonRelated());
			label.setWrapText(true);
			labelList.add(label);
		}
		if(content.getPlaceRelated() != null) {
			label = new Label("- Các địa điểm di tích lịch sử liên quan: "+ content.getPlaceRelated());
			label.setWrapText(true);
			labelList.add(label);
		}
		view.getChildren().addAll(labelList);
		return view;
	}
	private static VBox displayPerson(VBox view, Person content) {
		List<Label> labelList = new LinkedList<Label>();
		Label label; 
		if(content.getName() != null) {
			label = new Label("- Tên: "+ content.getName());
			label.setWrapText(true);
			labelList.add(label);
		}
		if(content.getDescription() != null) {
			label = new Label("- Mô tả: "+ content.getDescription());
			label.setWrapText(true);
			labelList.add(label);
		}
		
		if(content.getPeriod() != null) {
			label = new Label("- Triều đại: "+ content.getPeriod());
			label.setWrapText(true);
			labelList.add(label);
		}
		if(content.getBirth() != null) {
			label = new Label("- Sinh: "+ content.getBirth());
			label.setWrapText(true);
			labelList.add(label);
		}
		if(content.getDeath() != null) {
			label = new Label("- Mất: "+ content.getDeath());
			label.setWrapText(true);
			labelList.add(label);
		}
		if(content.getReignTime() != null) {
			label = new Label("- Thời gian tại vị: "+ content.getReignTime());
			label.setWrapText(true);
			labelList.add(label);
		}
		if(content.getPredecessor() != null) {
			label = new Label("- Tiền nhiệm: "+ content.getPredecessor());
			label.setWrapText(true);
			labelList.add(label);
		}
		if(content.getSuccessor() != null) {
			label = new Label("- Kế nhiệm: "+ content.getSuccessor());
			label.setWrapText(true);
			labelList.add(label);
		}
		if(content.getRealName() != null) {
			label = new Label("- Tên thật: "+ content.getRealName());
			label.setWrapText(true);
			labelList.add(label);
		}
		if(content.getNienHieu() != null) {
			label = new Label("- Niên hiệu: "+ content.getNienHieu());
			label.setWrapText(true);
			labelList.add(label);
		}
		if(content.getTenHuy() != null) {
			label = new Label("- Tên húy: "+ content.getTenHuy());
			label.setWrapText(true);
			labelList.add(label);
		}
		if(content.getThuyHieu() != null) {
			label = new Label("- Thụy hiệu: "+ content.getThuyHieu());
			label.setWrapText(true);
			labelList.add(label);
		}
		if(content.getMieuHieu() != null) {
			label = new Label("- Miếu hiệu: "+ content.getMieuHieu());
			label.setWrapText(true);
			labelList.add(label);
		}
		if(content.getFather() != null) {
			label = new Label("- Cha: "+ content.getFather());
			label.setWrapText(true);
			labelList.add(label);
		}
		if(content.getMother() != null) {
			label = new Label("- Mẹ: "+ content.getMother());
			label.setWrapText(true);
			labelList.add(label);
		}
		if(content.getChildrens() != null) {
			label = new Label("- Con: "+ content.getChildrens());
			label.setWrapText(true);
			labelList.add(label);
		}
		if(content.getAnTang() != null) {
			label = new Label("- An táng: "+ content.getAnTang());
			label.setWrapText(true);
			labelList.add(label);
		}
		if(content.getTonGiao() != null) {
			label = new Label("- Tôn giáo: "+ content.getTonGiao());
			label.setWrapText(true);
			labelList.add(label);
		}
		if(content.getNhiepChinh() != null) {
			label = new Label("- Nhiếp chính: "+ content.getNhiepChinh());
			label.setWrapText(true);
			labelList.add(label);
		}
		if(content.getTheThiep() != null) {
			label = new Label("- Vợ/Thê thiếp: "+ content.getTheThiep());
			label.setWrapText(true);
			labelList.add(label);
		}
		if(content.getRole() != null) {
			label = new Label("- Chức vị: "+ content.getRole());
			label.setWrapText(true);
			labelList.add(label);
		}
		
		if(content.getEventRelated() != null) {
			label = new Label("- Các sự kiện liên quan: "+ content.getEventRelated());
			label.setWrapText(true);
			labelList.add(label);
		}
		if(content.getFestivalRelated() != null) {
			label = new Label("- Các lễ hội liên quan: "+ content.getFestivalRelated());
			label.setWrapText(true);
			labelList.add(label);
		}
		if(content.getPeriodRelated() != null) {
			label = new Label("- Các triều đại liên quan: "+ content.getPeriodRelated());
			label.setWrapText(true);
			labelList.add(label);
		}
		if(content.getPersonRelated() != null) {
			label = new Label("- Các nhân vật lịch sử liên quan: "+ content.getPersonRelated());
			label.setWrapText(true);
			labelList.add(label);
		}
		if(content.getPlaceRelated() != null) {
			label = new Label("- Các địa điểm di tích lịch sử liên quan: "+ content.getPlaceRelated());
			label.setWrapText(true);
			labelList.add(label);
		}
		view.getChildren().addAll(labelList);
		return view;

	}
	private static VBox displayPlace(VBox view, Place content) {
		List<Label> labelList = new LinkedList<Label>();
		Label label; 
		if(content.getName() != null) {
			label = new Label("- Tên: "+ content.getName());
			label.setWrapText(true);
			labelList.add(label);
		}
		if(content.getDescription() != null) {
			label = new Label("- Mô tả: "+ content.getDescription());
			label.setWrapText(true);
			labelList.add(label);
		}
		
		if(content.getToaDo() != null) {
			label = new Label("- Tọa độ: "+ content.getToaDo());
			label.setWrapText(true);
			labelList.add(label);
		}
		if(content.getViTri() != null) {
			label = new Label("- Vị trí: "+ content.getViTri());
			label.setWrapText(true);
			labelList.add(label);
		}
		if(content.getDienTich() != null) {
			label = new Label("- Diện tích: "+ content.getDienTich());
			label.setWrapText(true);
			labelList.add(label);
		}
		if(content.getChieuCao() != null) {
			label = new Label("- Chiều cao: "+ content.getChieuCao());
			label.setWrapText(true);
			labelList.add(label);
		}
		if(content.getThoiGianXayDung() != null) {
			label = new Label("- Xây dựng: "+ content.getThoiGianXayDung());
			label.setWrapText(true);
			labelList.add(label);
		}
		if(content.getDanSo() != null) {
			label = new Label("- Dân số: "+ content.getDanSo());
			label.setWrapText(true);
			labelList.add(label);
		}
		if(content.getMatDo() != null) {
			label = new Label("- Mật độ: "+ content.getMatDo());
			label.setWrapText(true);
			labelList.add(label);
		}
		if(content.getQuocGia() != null) {
			label = new Label("- Quốc gia: "+ content.getQuocGia());
			label.setWrapText(true);
			labelList.add(label);
		}
		if(content.getTinh() != null) {
			label = new Label("- Tỉnh: "+ content.getTinh());
			label.setWrapText(true);
			labelList.add(label);
		}
		if(content.getHuyen() != null) {
			label = new Label("- Huyện: "+ content.getHuyen());
			label.setWrapText(true);
			labelList.add(label);
		}
		if(content.getMaHanhchinh() != null) {
			label = new Label("- Mã hành chính: "+ content.getMaHanhchinh());
			label.setWrapText(true);
			labelList.add(label);
		}
		if(content.getLehoi() != null) {
			label = new Label("- Lễ hội: "+ content.getLehoi());
			label.setWrapText(true);
			labelList.add(label);
		}
		if(content.getNguon() != null) {
			label = new Label("- Nguồn: "+ content.getNguon());
			label.setWrapText(true);
			labelList.add(label);
		}
		if(content.getPhuLuu() != null) {
			label = new Label("- Phụ lưu: "+ content.getPhuLuu());
			label.setWrapText(true);
			labelList.add(label);
		}
		if(content.getChieudai() != null) {
			label = new Label("- Chiều dài: "+ content.getChieudai());
			label.setWrapText(true);
			labelList.add(label);
		}
		if(content.getLuuLuong() != null) {
			label = new Label("- Lưu lượng: "+ content.getLuuLuong());
			label.setWrapText(true);
			labelList.add(label);
		}
		if(content.getDoSau() != null) {
			label = new Label("- Độ sâu: "+ content.getDoSau());
			label.setWrapText(true);
			labelList.add(label);
		}
		if(content.getEventRelated() != null) {
			label = new Label("- Các sự kiện liên quan: "+ content.getEventRelated());
			label.setWrapText(true);
			labelList.add(label);
		}
		if(content.getFestivalRelated() != null) {
			label = new Label("- Các lễ hội liên quan: "+ content.getFestivalRelated());
			label.setWrapText(true);
			labelList.add(label);
		}
		if(content.getPeriodRelated() != null) {
			label = new Label("- Các triều đại liên quan: "+ content.getPeriodRelated());
			label.setWrapText(true);
			labelList.add(label);
		}
		if(content.getPersonRelated() != null) {
			label = new Label("- Các nhân vật lịch sử liên quan: "+ content.getPersonRelated());
			label.setWrapText(true);
			labelList.add(label);
		}
		if(content.getPlaceRelated() != null) {
			label = new Label("- Các địa điểm di tích lịch sử liên quan: "+ content.getPlaceRelated());
			label.setWrapText(true);
			labelList.add(label);
		}
		view.getChildren().addAll(labelList);
		return view;
	}
}
