package org.shibayu36.shibasticsearch.tokenizer;

public class NGramTokenizer {
  private String text;
  private int n;
  private int currentIndex;

  /**
   *
   * @param text トークナイズしたいテキスト
   * @param n 何文字単位でトークナイズするか
   */
  public NGramTokenizer(String text, int n) {
    this.text = text;
    this.n = n;
    this.currentIndex = 0;
  }

  /**
   * 次のトークンを取得する
   */
  public String next() {
    int beginIndex = this.currentIndex;
    int endIndex = Math.min(beginIndex + this.n, this.text.length());
    this.currentIndex++;
    return this.text.substring(beginIndex, endIndex);
  }

  /**
   * 次のトークンがあるか
   */
  public boolean hasNext() {
    return this.currentIndex < text.length();
  }
}
