package br.feevale.bytechat.packet;

public class File implements Packet {

	private static final long serialVersionUID = -3966402991280252965L;
	
	private String fileId;
	private String name;
	private String contentType;
	
	private int part;
	private int totalParts;
	
	private byte[] contents;
	
	public String getFileId() {
		return fileId;
	}

	public void setFileId(String fileId) {
		this.fileId = fileId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getContentType() {
		return contentType;
	}

	public void setContentType(String contentType) {
		this.contentType = contentType;
	}

	public int getPart() {
		return part;
	}

	public void setPart(int part) {
		this.part = part;
	}

	public int getTotalParts() {
		return totalParts;
	}

	public void setTotalParts(int totalParts) {
		this.totalParts = totalParts;
	}

	public byte[] getContents() {
		return contents;
	}

	public void setContents(byte[] contents) {
		this.contents = contents;
	}

	@Override
	public PacketType getType() {
		return PacketType.FILE;
	}

}
