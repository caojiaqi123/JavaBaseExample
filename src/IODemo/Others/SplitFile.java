package IODemo.Others;

import com.sun.deploy.util.StringUtils;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * 文件分割
 */
public class SplitFile {
    private String filePath;
    private long blockSize;
    private int size;
    List<String> blockPath;
    private long fileLength;
    private String fileName;

    public SplitFile(String filePath) {
        this(filePath, 1024);
    }

    public SplitFile(String filePath, long blockSize) {
        this();
        this.filePath = filePath;
        this.blockSize = blockSize;
        init();
    }

    public SplitFile() {
        blockPath = new ArrayList<>();
    }


    private void init() {
        File src = null;
        //文件是否存在
        if (filePath == null || !((src = new File(filePath)).exists())) {
            return;
        }
        if (src.isDirectory()) {
            return;
        }
        fileName = src.getName();
        fileLength = src.length();
        if (fileLength < blockSize) {
            blockSize = fileLength;
        }
        //分成多少快
        size = (int) Math.ceil(fileLength * 1.0 / blockSize);

    }

    public void spild(String deptPath) throws IOException {

        //每个文件命名
        for (int i = 0; i < size; i++) {
            blockPath.add(deptPath + "/" + fileName + ".part" + i);
        }

        int beginPos = 0;
        long acturalBlockSize = blockSize;
        for (int i = 0; i < this.size; i++) {
            if (i == this.size - 1) {
                acturalBlockSize = this.fileLength - beginPos;
            }
            splitFile(i, beginPos, acturalBlockSize);

            beginPos += acturalBlockSize;
        }
    }

    public void splitFile(int index, int beginPos, long acturalSize) throws IOException {
        File src = new File(this.filePath);
        File dest = new File(this.blockPath.get(index));
        BufferedOutputStream os = new BufferedOutputStream(new FileOutputStream(dest));
        try (RandomAccessFile rnd = new RandomAccessFile(src, "r")) {
            rnd.seek(beginPos);

            //读文件
            byte[] flush = new byte[1024];
            int len = 0;

            while (-1 != (len = rnd.read(flush))) {
                if (len >= acturalSize) {
                    os.write(flush, 0, (int) acturalSize);
                    break;
                } else {
                    os.write(flush, 0, len);
                    break;
                }
            }
            os.flush();
            os.close();
        }

    }

    public void mergeFile(String dest) throws IOException {

        BufferedOutputStream os = new BufferedOutputStream(new FileOutputStream(new File(dest), true));
        BufferedInputStream is = null;
        for (String s : blockPath) {
            is = new BufferedInputStream(new FileInputStream(new File(s)));
            int len = 0;
            byte[] flush = new byte[1024];

            while (-1 != (len = is.read(flush))) {
                os.write(flush,0,len);
            }
            os.flush();
            is.close();
        }
    }

    public static void main(String[] args) throws IOException {
        SplitFile splitFile = new SplitFile("/Users/caojiaqi/Projects/JavaProjects/JavaData/test/copy.txt", 100);
        System.out.println(splitFile.size);

        splitFile.spild("/Users/caojiaqi/Projects/JavaProjects/JavaData/test/");
        splitFile.mergeFile("/Users/caojiaqi/Projects/JavaProjects/JavaData/test/dest.txt");

    }
}
