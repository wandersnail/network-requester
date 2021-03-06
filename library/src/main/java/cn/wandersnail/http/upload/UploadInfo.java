package cn.wandersnail.http.upload;

import androidx.annotation.NonNull;

import java.util.List;
import java.util.Map;

import cn.wandersnail.http.TaskInfo;
import okhttp3.OkHttpClient;
import okhttp3.ResponseBody;
import retrofit2.Converter;

/**
 * date: 2019/8/23 17:46
 * author: zengfansheng
 */
public class UploadInfo<T> extends TaskInfo {
    Converter<ResponseBody, T> converter;
    Map<String, String> paramParts;
    OkHttpClient client;
    Map<String, String> headers;
    List<FileInfo> fileInfos;

    public UploadInfo(@NonNull String tag, @NonNull String url) {
        super(tag, url);
    }

    public UploadInfo(@NonNull String url) {
        super(url);
    }

    public UploadInfo<T> setFileParts(List<FileInfo> fileInfos) {
        this.fileInfos = fileInfos;
        return this;
    }

    public UploadInfo<T> setHeaders(Map<String, String> headers) {
        this.headers = headers;
        return this;
    }

    /**
     * 设置响应体转换器
     */
    public UploadInfo<T> setConverter(@NonNull Converter<ResponseBody, T> converter) {
        this.converter = converter;
        return this;
    }

    /**
     * 设置携带的参数
     */
    public UploadInfo<T> setParamParts(@NonNull Map<String, String> paramParts) {
        this.paramParts = paramParts;
        return this;
    }

    /**
     * 设置自定义的OkHttpClient
     */
    public UploadInfo<T> setClient(@NonNull OkHttpClient client) {
        this.client = client;
        return this;
    }
}
