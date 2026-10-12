#version 330


uniform sampler2D InSampler;

in vec2 texCoord;
out vec4 fragColor;

void main(){
    vec4 InTexel = texture(InSampler, texCoord);

    fragColor = vec4(InTexel.r, InTexel.g, InTexel.z, 1.0);
}