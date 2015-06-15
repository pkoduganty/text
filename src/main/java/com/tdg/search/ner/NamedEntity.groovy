package com.tdg.search.ner

class NamedEntity {
	def token
	def type
	def charOffset
	def charOffsetEnd
	def tokenOffset
	
	NamedEntity(token, type, start, end, tokenOffset) {
		this.token=token
		this.type=type
		this.charOffset=start
		this.charOffsetEnd=end
		this.tokenOffset=tokenOffset
	}

	@Override
	public String toString() {
		return "NamedEntity [token=" + token + ", type=" + type
				+ ", charOffset=" + charOffset + ", charOffsetEnd="
				+ charOffsetEnd + ", tokenOffset=" + tokenOffset + "]";
	}
}
