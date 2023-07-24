package in.soumyadeb.shortify.service;

import in.soumyadeb.shortify.dto.QrCodeDto;

public interface QrCodeService {

    /**
     * Generates a QR code for provided shortUrlId.
     * <p>
     * This internally calls the QRCode service to generate the QR code and persists the ID of the
     * generated QR in {@link in.soumyadeb.shortify.entity.MapShortUrlQr}.
     *
     * @param shortUrlId ID of the shortUrl
     * @return {@link QrCodeDto} containing the QR code details
     */
    QrCodeDto generateQrCode(Integer shortUrlId);

    /**
     * Fetches QR code details for provided shortUrlId.
     *
     * @param shortUrlId ID of the shortUrl
     * @return {@link QrCodeDto} containing the QR code details
     */
    QrCodeDto getQrCode(Integer shortUrlId);

}
