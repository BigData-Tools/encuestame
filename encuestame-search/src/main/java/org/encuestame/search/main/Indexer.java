package org.encuestame.search.main;

import java.io.File;
import java.io.FileFilter;
import java.io.FileReader;
import java.io.IOException;

import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.document.Field;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.FSDirectory;
import org.apache.lucene.util.Version;

/**
 * Create an Index.
 * Store information indexed
 * @author dmorales
 */
public class Indexer {

    /**
     * @param indexDir The path to the index created with Indexer.
     * @param dataDir A query to use to search the index.
     * @param args
     * @throws Exception
     */
    public static void main(String[] args) throws Exception {
        // TODO Auto-generated method stub
        if (args.length != 2) {
            throw new IllegalArgumentException(
                    "Usage: java "
                            + Indexer.class.getName()
                            + " <index dir> <data dir>");

        }
        String indexDir = args[0]; // Create Index in this directory.
        String dataDir = args[1]; // Index *.txt files from this directory

        long start = System.currentTimeMillis();
        Indexer indexer = new Indexer(indexDir);
        int numIndexed;
        try {
            numIndexed = indexer.index(dataDir, new TextFilesFilter());
        } finally {
            indexer.close();
        }
        long end = System.currentTimeMillis();
        System.out.println("Indexing " + numIndexed + " files took "
                + (end - start) + " milliseconds");
    }

    private IndexWriter writer;

    /**
     * Create Lucene IndexWriter.
     * @param indexDir
     * @throws IOException
     */
    public Indexer(String indexDir) throws IOException {
        Directory dir = FSDirectory.open(new java.io.File(indexDir));
        writer = new IndexWriter(dir, new StandardAnalyzer(Version.LUCENE_29),
                true, IndexWriter.MaxFieldLength.UNLIMITED);
    }

    /**
     * Close Lucene IndexWriter.
     * @throws IOException
     */
    public void close() throws IOException {
        writer.close();
    }

    /**
     * Return number of documents indexed.
     * @param dataDir
     * @param filter
     * @return
     * @throws Exception
     */
    public int index(String dataDir, FileFilter filter) throws Exception {
        File[] files = new File(dataDir).listFiles();
        for (File f : files) {
            if (!f.isDirectory() && !f.isHidden() && f.exists() && f.canRead()
                    && (filter == null || filter.accept(f))) {
                indexFile(f);
            }
        }
        return writer.numDocs();

    }

    /**
     * Index .txt files only using FileFilter
     * @author dmorales
     */
    private static class TextFilesFilter implements FileFilter {
        public boolean accept(File path) {
            return path.getName().toLowerCase().endsWith(".txt");
        }
    }

    protected Document getDocument(File f) throws Exception {
        Document doc = new Document();
        doc.add(new Field("contents", new FileReader(f))); // Index file contents
        doc.add(new Field("filename", f.getName(), Field.Store.YES,
                Field.Index.NOT_ANALYZED)); // Index File Name.
        doc.add(new Field("fullpath", f.getCanonicalPath(), Field.Store.YES,
                Field.Index.NOT_ANALYZED)); // Index Full Path.
        return doc;
    }

    private void indexFile(File f) throws Exception {
        System.out.println("Indexing " + f.getCanonicalPath());
        Document doc = getDocument(f);
        writer.addDocument(doc); // Add Document to Lucene Index.
    }
}
