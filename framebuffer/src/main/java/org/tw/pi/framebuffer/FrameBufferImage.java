package org.tw.pi.framebuffer;

import java.awt.image.BufferedImage;
import java.awt.image.ColorModel;
import java.awt.image.DirectColorModel;
import java.awt.image.WritableRaster;

public class FrameBufferImage extends BufferedImage {
	static ColorModel createColorModel() {
		return new DirectColorModel(24,
                0x00ff0000,   // Red
                0x0000ff00,   // Green
                0x000000ff,   // Blue
                0x0           // Alpha
                );
	}
	
	static WritableRaster createWritableRaster(FrameBufferDataBuffer dataBuffer) {
		return new FrameBufferRaster(dataBuffer);
	}
	
	private FrameBufferDataBuffer dataBuffer;
	
	public FrameBufferImage(String fbdev) {
		this(new FrameBufferDataBuffer(fbdev));
	}
	
	public FrameBufferImage(FrameBufferDataBuffer dataBuffer) {
		super(createColorModel(), createWritableRaster(dataBuffer), true, null);
		this.dataBuffer = dataBuffer;
	}
	
	public void close() {
		dataBuffer.close();
	}
}
