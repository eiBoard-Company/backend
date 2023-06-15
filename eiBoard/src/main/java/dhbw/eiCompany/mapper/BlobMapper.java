package dhbw.eiCompany.mapper;

import java.sql.Blob;

import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

import dhbw.eiCompany.BlobConverter;

@Mapper(componentModel = "spring")
@Component
public class BlobMapper {

	public Blob map(byte[] value) {
		if(value == null) {
			return null;
		}
		return BlobConverter.convertByteArrayToBlob(value);
	}

	public byte[] map(Blob value) {
		if(value == null) {
			return null;
		}
		return BlobConverter.convertBlobToByteArray(value);
	}
	
	public String mapBlob(final Blob value) {
		if (value == null) {
			return null;
		}
		return BlobConverter.convertBlobToBase64String(value);
	}

	public Blob mapBlob(final String value) {
		if (value == null) {
			return null;
		}
		return BlobConverter.convertBase64StringToBlob(value);
	}
}
